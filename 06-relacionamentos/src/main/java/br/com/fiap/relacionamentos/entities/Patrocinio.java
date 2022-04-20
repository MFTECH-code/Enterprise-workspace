package br.com.fiap.relacionamentos.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PATROCINIO")
@SequenceGenerator(sequenceName = "sq_patrocinio", name = "sq_patrocinio", allocationSize = 1)
public class Patrocinio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_patrocinio")
	@Column(name = "cd_patrocinio")
	private Integer codigo;
	
	@Column(name = "nm_marca", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "dt_fim_contrato", nullable = false)
	private LocalDate dataFimContrato;

	@ManyToMany(mappedBy = "patrocinios")
	private List<Time> times;

	public Patrocinio(Integer codigo, String nome, LocalDate dataFimContrato) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataFimContrato = dataFimContrato;
	}
	
	public Patrocinio() {
		super();
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

	public LocalDate getDataFimContrato() {
		return dataFimContrato;
	}

	public void setDataFimContrato(LocalDate dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}
}
