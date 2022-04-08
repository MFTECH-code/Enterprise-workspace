package br.com.fiap.relacionamentos.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TIME")
@SequenceGenerator(sequenceName = "sq_time", name = "sq_time", allocationSize = 1)
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_time")
	@Column(name = "cd_time")
	private Integer codigo;
	
	// Relacionamento 1:1
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "cd_tecnico", nullable = false)
	private Tecnico tecnico;

	@Column(name = "nm_time", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "nm_estadio", length = 50)
	private String nomeEstadio;

	public Time(Tecnico tecnico, String nome, String nomeEstadio) {
		super();
		this.tecnico = tecnico;
		this.nome = nome;
		this.nomeEstadio = nomeEstadio;
	}
	
	public Time() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeEstadio() {
		return nomeEstadio;
	}

	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}
}
