package br.com.fiap.jpa.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.exception.TransactionExcepion;

public abstract class DaoImplementAbstract {
	protected EntityManager em;
	
	public DaoImplementAbstract(EntityManager em) {
		this.em = em;
	}
	
	protected void doTransactions() throws TransactionExcepion {
		try {			
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			throw new TransactionExcepion("Erro de transação, não foi possível realizar commit...");
		}
	}
}
