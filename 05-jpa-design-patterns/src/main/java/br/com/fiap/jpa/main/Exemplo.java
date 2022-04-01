package br.com.fiap.jpa.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.entities.Garagem;
import br.com.fiap.jpa.entities.Tipo;
import br.com.fiap.jpa.entities.Veiculo;
import br.com.fiap.jpa.exception.InexistentItemException;
import br.com.fiap.jpa.implement.GaragemDaoImplement;
import br.com.fiap.jpa.implement.VeiculoDaoImplement;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		GaragemDaoImplement garagemDao = new GaragemDaoImplement(em);
		VeiculoDaoImplement veiculoDao = new VeiculoDaoImplement(em);
		
		Garagem garagem = new Garagem("Garagem quatro amigos");
		Veiculo veiculo = new Veiculo("SUV", 200000.0, 2010, LocalDate.now(), Tipo.CARRO, "123A");
		
		garagemDao.insert(garagem);
		veiculoDao.cadastrar(veiculo);
		
		Garagem garagem2 = new Garagem("Garagem tres amigos");
		Veiculo veiculo2 = new Veiculo("SUV", 200000.0, 2010, LocalDate.now(), Tipo.CARRO, "12asCA");
		
		garagemDao.insert(garagem);
		veiculoDao.cadastrar(veiculo);
		
		try {
			Garagem garagem3 = garagemDao.find(1);
			Veiculo veiculo3 = veiculoDao.procurar(1);
			garagem3.setNome("KKKKKKKKKKKK");
			veiculo3.setValor(99999.9);
			
			garagemDao.update(garagem3);
			veiculoDao.atualizar(veiculo3);
		} catch (InexistentItemException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			garagemDao.remove(1);
			veiculoDao.apagar(1);
		} catch (InexistentItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		factory.close();
	}

}
