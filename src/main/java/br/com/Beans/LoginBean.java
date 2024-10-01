package br.com.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.Entities.Usuario;
import br.com.GenericDao.UsuarioDao;

@ManagedBean(name = "loginBean")
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	private UsuarioDao<Usuario> usuarioDao = new UsuarioDao<Usuario>();

	public String Logar() {
		Usuario usuarioLogar = usuarioDao.consultarUsuario(usuario.getUsername(), usuario.getEmail(), usuario.getSenha());
		
		if(usuarioLogar != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.getSessionMap().put("usuarioLogado", usuarioLogar);
		}
		
		
		return "homePage?faces-redirect=true";
	}
	
	
	public String Registrar() {
		usuarioDao.Register(usuario);
		usuario = new Usuario();
		return "loginPage?faces-redirect=true";
	}
	
	public String Logout() {
		usuarioDao.Logout();
		return "loginPage?faces-redirect=true";
	}
	
	public String Redirect() {
		return "registerPage?faces-redirect=true";
	}
	
	public String getNomeUsuario() {
		return usuarioDao.GetUsuario().getUsername();
	}

	//getters e setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao<Usuario> getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao<Usuario> usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	
}
