package br.com.fiap.relacionamentos.dao.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.implement.DaoImplement;
import br.com.fiap.relacionamentos.dao.PatrocinioDao;
import br.com.fiap.relacionamentos.entities.Patrocinio;

public class PatrocinioDaoImpl extends DaoImplement<Patrocinio, Integer> implements PatrocinioDao {

	public PatrocinioDaoImpl(EntityManager em) {
		super(em);
	}

}
