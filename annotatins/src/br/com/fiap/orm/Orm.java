package br.com.fiap.orm;

import br.com.fiap.anotacao.Tabela;

public class Orm {

	
	
	public String pesquisar(Object obj) throws NoSuchFieldException, SecurityException {
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		
		return "SELCET * FROM " + anotacao.nome();
	}
}
