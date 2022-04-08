package br.com.fiap.relacionamentos.dao.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.implement.DaoImplement;
import br.com.fiap.relacionamentos.dao.JogadorDao;
import br.com.fiap.relacionamentos.entities.Jogador;

public class JogadorDaoImpl extends DaoImplement<Jogador, Integer> implements JogadorDao {

	public JogadorDaoImpl(EntityManager em) {
		super(em);
	}

}
