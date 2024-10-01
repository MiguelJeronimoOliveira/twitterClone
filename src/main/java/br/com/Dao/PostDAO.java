package br.com.Dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

import br.com.Entities.Usuario;
import br.com.Util.JPAUtil;

public class PostDAO<P> {

	protected EntityManager entityManager = JPAUtil.getEntityManager();
	protected EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void Postar(P entidade) {
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		entityTransaction.commit();
	}
	
	public void Deletar(P entidade) {
		entityTransaction.begin();
		
		entityManager.remove(entidade);
		entityTransaction.commit();	
	}
	
	public P Editar(P entidade) {
		entityTransaction.begin();
		P retorno = entityManager.merge(entidade);
		entityTransaction.commit();
		
		return retorno;
	}
	
	public List<P> TimeLine(Class<P> entidade){
		entityTransaction.begin();
		
		List<P> lista = entityManager.createQuery("from " +  entidade.getName()).getResultList();
		
		entityTransaction.commit();
		return lista;
	}
	
	public Usuario GetUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return usuario;
	}
	
}
