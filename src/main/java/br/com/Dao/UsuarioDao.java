package br.com.Dao;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;


import br.com.Entities.Usuario;
import br.com.Util.JPAUtil;

public class UsuarioDao<U> {

	protected EntityManager entityManager = JPAUtil.getEntityManager();
	protected EntityTransaction entityTransaction = entityManager.getTransaction();

	public void Register(U entidade) {
		entityTransaction.begin();

		entityManager.persist(entidade);
		entityTransaction.commit();
	}

	public Usuario consultarUsuario(String username, String email, String senha) {
		
		Usuario usuario = null;
		
        usuario = (Usuario) entityManager.createQuery(
                "select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class)
                .setParameter("email", email)
                .setParameter("senha", senha)
                .getSingleResult();

		return usuario;
	}
	
	public Usuario GetUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return usuario;
	}
	
	public String GetNomeUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		return usuario.getUsername();
	}
	
	
	public void Logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		
		session.invalidate();
	}

}
