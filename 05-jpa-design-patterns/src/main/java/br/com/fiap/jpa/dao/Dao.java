package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.InexistentItemException;

public interface Dao<T, K> {
	void insert(T object);
	
	T find(K id) throws InexistentItemException;
	
	void update(T object);
	
	void remove(K id) throws InexistentItemException;
}
