package br.com.fiap.relacionamentos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.exception.InexistentItemException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.relacionamentos.dao.implement.TimeDaoImpl;
import br.com.fiap.relacionamentos.entities.Patrocinio;
import br.com.fiap.relacionamentos.entities.Time;

public class ExemploBusca {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		TimeDaoImpl timeDao = new TimeDaoImpl(em);
		
		try {
			Time time = timeDao.find(1);
			System.out.println("TIME:");
			System.out.println(time.getNome());
			System.out.println("TECNICO:");
			System.out.println(time.getTecnico().getNome());
			for (Patrocinio p : time.getPatrocinios()) {
				System.out.println("Patrocinador:" + p.getNome());
			}
		} catch (InexistentItemException e) {
			System.out.println("ID selecionado não existe na base de dados...");
			e.printStackTrace();
		}
		
	 

		em.close();
		factory.close();
	}

}
