package br.com.fiap.relacionamentos.dao.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.implement.DaoImplement;
import br.com.fiap.relacionamentos.dao.TecnicoDao;
import br.com.fiap.relacionamentos.entities.Tecnico;

public class TecnicoDaoImpl extends DaoImplement<Tecnico, Integer> implements TecnicoDao {

	public TecnicoDaoImpl(EntityManager em) {
		super(em);
	}

}
