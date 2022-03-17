package br.com.fiap.main;

import java.lang.reflect.Field;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Produto;
import br.com.fiap.orm.Orm;

public class Program {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Produto produto = new Produto();
		
		System.out.println(produto.getClass().getName());
		
		Field[] atributos = produto.getClass().getDeclaredFields();
		
		for (Field f : atributos) {
			// Recuperar a anotação de cada atributo
			Coluna anotacao = f.getAnnotation(Coluna.class);
			System.out.println(anotacao.chavePrimaria());
			System.out.println(anotacao.nome());
			System.out.println(anotacao.obrigatorio());
		}
		
		Aluno aluno = new Aluno();
		Orm orm = new Orm();
		
		System.out.println(orm.pesquisar(produto));
				
		
	}
}
