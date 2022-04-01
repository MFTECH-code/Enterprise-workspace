package br.com.fiap.jpa.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GaragemDao;
import br.com.fiap.jpa.entities.Garagem;

public class GaragemDaoImplement extends DaoImplement<Garagem, Integer> implements GaragemDao {

	public GaragemDaoImplement(EntityManager em) {
		super(em);
	}

}