package br.com.fiap.jpa.implement;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.Dao;
import br.com.fiap.jpa.exception.InexistentItemException;
import br.com.fiap.jpa.exception.TransactionExcepion;

public abstract class DaoImplement<T, K> extends DaoImplementAbstract implements Dao<T, K> {
	
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public DaoImplement(EntityManager em) {
		super(em);
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void insert(T object) {
		em.persist(object);
		
		try {
			doTransactions();
		} catch (TransactionExcepion e) {
			e.printStackTrace();
		}
	}

	public T find(K id) throws InexistentItemException {

		T object = em.find(clazz, id);
		
		if (object != null) {
			return object;
		}
		
		throw new InexistentItemException();
	}

	public void update(T object) {
		em.merge(object);
		
		try {
			doTransactions();
		} catch (TransactionExcepion e) {
			e.printStackTrace();
		}
		
	}

	public void remove(K id) throws InexistentItemException {
		T object = find(id);
		em.remove(object);
		
		try {
			doTransactions();
		} catch (TransactionExcepion e) {
			e.printStackTrace();
		}
	}
	
}
