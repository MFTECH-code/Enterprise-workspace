package br.com.fiap.relacionamentos.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.relacionamentos.dao.implement.TecnicoDaoImpl;
import br.com.fiap.relacionamentos.dao.implement.TimeDaoImpl;
import br.com.fiap.relacionamentos.entities.Jogador;
import br.com.fiap.relacionamentos.entities.Patrocinio;
import br.com.fiap.relacionamentos.entities.PosicaoJogador;
import br.com.fiap.relacionamentos.entities.Tecnico;
import br.com.fiap.relacionamentos.entities.Time;

public class ExemploCadastro {

	public static void main(String[] args) {
		// Cadastrar um Time e um t?cnico
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		TimeDaoImpl timeDao = new TimeDaoImpl(em);
		TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl(em);
		
		// Cadastrar 2 patrocinadores 
		Patrocinio patrocinador1 = new Patrocinio("Cacha?a Pitu", LocalDate.of(2022, 12, 31));
		
		List<Patrocinio> listaDePatrocinadore = new ArrayList<Patrocinio>();
		listaDePatrocinadore.add(patrocinador1);
		
		Tecnico tecnico = new Tecnico("Gil", LocalDate.of(1997, 11, 28), 20);
		Time time = new Time(tecnico, "Flamengo", "Campo de barro melado", listaDePatrocinadore);

		Jogador jogador1 = new Jogador("Israel", 10, PosicaoJogador.ATACANTE, 20000.0, time);
		Jogador jogador2 = new Jogador("Messi", 11, PosicaoJogador.ATACANTE, 30000.0, time);
		
	
		
		time.addJogador(jogador1);
		time.addJogador(jogador2);
		
		tecnicoDao.insert(tecnico);
		timeDao.insert(time);
		
		
		em.close();
		factory.close();
	}

}
