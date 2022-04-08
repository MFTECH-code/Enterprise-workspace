package br.com.fiap.relacionamentos.dao.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.implement.DaoImplement;
import br.com.fiap.relacionamentos.entities.Time;

public class TimeDaoImpl extends DaoImplement<Time, Integer> {

	public TimeDaoImpl(EntityManager em) {
		super(em);
	}

}
