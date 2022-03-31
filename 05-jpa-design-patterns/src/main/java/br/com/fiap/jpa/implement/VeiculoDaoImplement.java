package br.com.fiap.jpa.implement;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.VeiculoDao;
import br.com.fiap.jpa.entities.Veiculo;
import br.com.fiap.jpa.exception.InexistentItemException;
import br.com.fiap.jpa.exception.TransactionExcepion;

public class VeiculoDaoImplement extends DaoImplementAbstract implements VeiculoDao {
	
	public VeiculoDaoImplement(EntityManager em) {
		super(em);
	}
	
	public void cadastrar(Veiculo veiculo) {
		em.persist(veiculo);
		
		try {
			doTransactions();
		} catch (TransactionExcepion e) {
			e.printStackTrace();
		}
	}

	public Veiculo procurar(Integer id) throws InexistentItemException {
		Veiculo result = em.find(Veiculo.class, id);
		if (result != null) {
			return result;			
		}
		throw new InexistentItemException();
	}

	public void atualizar(Veiculo veiculo) {
		em.merge(veiculo);
		
		try {
			doTransactions();
		} catch (TransactionExcepion e) {
			e.printStackTrace();
		}
		
	}

	public void apagar(Integer id) {
		Veiculo veiculo;
		try {
			veiculo = procurar(id);
			em.remove(veiculo);
			doTransactions();
		} catch (InexistentItemException e1) {
			e1.printStackTrace();
		} catch (TransactionExcepion e) {
			e.printStackTrace();
		}
	}
}
