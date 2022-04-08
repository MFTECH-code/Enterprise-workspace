package br.com.fiap.relacionamentos.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TECNICO")
@SequenceGenerator(sequenceName = "sq_tecnico", name = "sq_tecnico", allocationSize = 1)
public class Tecnico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tecnico")
	@Column(name = "cd_tecnico")
	private Integer codigo;
	
	// Relacionamento 1:1 - Bidirecional (Não precisa criar)
	// MappedBy obrigatório no lado que não recebe FK, o nome do atributo que mapeia a relação
	@OneToOne(mappedBy = "tecnico")
	private Time time;
	
	@Column(name = "nm_tecnico", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "nr_tempo_carreira")
	private Integer tempoCarreira;

	public Tecnico(String nome, LocalDate dataNascimento, Integer tempoCarreira) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tempoCarreira = tempoCarreira;
	}
	
	public Tecnico() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTempoCarreira() {
		return tempoCarreira;
	}

	public void setTempoCarreira(Integer tempoCarreira) {
		this.tempoCarreira = tempoCarreira;
	}
}
