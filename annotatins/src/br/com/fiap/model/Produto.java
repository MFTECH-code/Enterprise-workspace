package br.com.fiap.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

@Tabela(nome="tb_produto")
public class Produto {
	@Coluna(nome="cd_produto", chavePrimaria=true, obrigatorio=true)
	private Integer codigo;
	
	@Coluna(nome="nm+produto")
	private String nome;
	
	@Coluna(nome="ds_descricao")
	private String descricao;
	
	@Coluna(nome="vl_produto")
	private BigDecimal valor;
	
	@Coluna(nome="dt_cadastro")
	private LocalDate dataCadastro;

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
