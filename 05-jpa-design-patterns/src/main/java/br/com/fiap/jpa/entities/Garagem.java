package br.com.fiap.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GARAGEM")
@SequenceGenerator(name = "sq_garagem", sequenceName = "sq_garagem", allocationSize = 1)
public class Garagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "sq_garagem")
	@Column(name = "cd_garagem")
	private Integer codigo;
	
	@Column(name = "nm_garagem", nullable = false)
	private String nome;
	
	public Garagem() {
		super();
	}

	public Garagem(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
