package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Empresa;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.TipoEmpresa;

public class ExemploCadastro {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = new Cliente("Knaaaae", "maaaasasats@mail.com", new BigDecimal(100), LocalDate.of(2000, 11, 28), Genero.MASCULINO);
		
		em.persist(cliente);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("Cliente cadastrado!");
		
		/*
		Empresa empresa = new Empresa("Hospital Ka", "309292919", TipoEmpresa.SAUDE, LocalDate.of(1997, 7, 28));
		
		em.persist(empresa);
		*/
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("Empresa cadastrada!");
		
		factory.close();
	}
}
