package br.com.fiap.jpa.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.entities.Garagem;
import br.com.fiap.jpa.entities.Tipo;
import br.com.fiap.jpa.entities.Veiculo;
import br.com.fiap.jpa.implement.GaragemDaoImplement;
import br.com.fiap.jpa.implement.VeiculoDaoImplement;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		Garagem garagem = new Garagem("Garagem dois amigos");
		Veiculo veiculo = new Veiculo("SUV", 200000.0, 2010, LocalDate.now(), Tipo.CARRO, "123FACA");
		
		
		GaragemDaoImplement garagemDao = new GaragemDaoImplement(em);
		garagemDao.insert(garagem);
		
		VeiculoDaoImplement veiculoDao = new VeiculoDaoImplement(em);
		veiculoDao.cadastrar(veiculo);
		
		factory.close();
	}

}
