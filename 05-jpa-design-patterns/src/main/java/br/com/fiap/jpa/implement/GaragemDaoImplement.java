package br.com.fiap.jpa.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entities.Garagem;

public class GaragemDaoImplement extends DaoImplement<Garagem, Integer> {

	public GaragemDaoImplement(EntityManager em) {
		super(em);
	}

}