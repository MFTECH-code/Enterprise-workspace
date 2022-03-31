package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entities.Veiculo;
import br.com.fiap.jpa.exception.InexistentItemException;

public interface VeiculoDao {
	void cadastrar(Veiculo veiculo);
	
	Veiculo procurar(Integer id) throws InexistentItemException;
	
	void atualizar(Veiculo veiculo);
	
	void apagar(Integer id);
}
