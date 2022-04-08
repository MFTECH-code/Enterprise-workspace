package br.com.fiap.relacionamentos.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.relacionamentos.dao.implement.TecnicoDaoImpl;
import br.com.fiap.relacionamentos.dao.implement.TimeDaoImpl;
import br.com.fiap.relacionamentos.entities.Tecnico;
import br.com.fiap.relacionamentos.entities.Time;

public class ExemploCadastro {

	public static void main(String[] args) {
		// Cadastrar um Time e um técnico
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		TimeDaoImpl timeDao = new TimeDaoImpl(em);
		TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl(em);
		
		
		Tecnico tecnico = new Tecnico("Fuleco Gil", LocalDate.of(1997, 11, 28), 20);
		Time time = new Time(tecnico, "Fluminense", "Campo de barro");
		
		tecnicoDao.insert(tecnico);
		
		timeDao.insert(time);
		
		
		em.close();
		factory.close();
	}

}
