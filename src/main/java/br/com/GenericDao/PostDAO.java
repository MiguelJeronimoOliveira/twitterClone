package br.com.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
	
	public void Editar(P entidade) {
		entityTransaction.begin();
		
		entityManager.merge(entidade);
		entityTransaction.commit();
	}
	
	
	
}
