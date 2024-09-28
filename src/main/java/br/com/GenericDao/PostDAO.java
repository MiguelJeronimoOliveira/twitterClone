package br.com.GenericDao;

import java.util.List;

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
	
	public P Editar(P entidade) {
		entityTransaction.begin();
		P retorno = entityManager.merge(entidade);
		entityTransaction.commit();
		
		return retorno;
	}
	
	public List<P> Posts (Class<P> entidade){
		List<P> lista = entityManager.createQuery("from " + entidade.getName() + "order by id ASC").getResultList();
		return lista;
	}
	
	
}
