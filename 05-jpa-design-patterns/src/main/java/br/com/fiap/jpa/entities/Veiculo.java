package br.com.fiap.jpa.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_veiculo")
public class Veiculo {
	
	@Id
	@SequenceGenerator(name = "sq_veiculo", allocationSize = 1, sequenceName = "sq_veiculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_vaiculo")
	@Column(name = "cd_veiculo", insertable = false)
	private Integer codigo;
	
	@Column(name = "ds_modelo", length = 50)
	private String modelo;
	
	@Column(name = "vl_veiculo", length = 10, scale = 2)
	private Double valor;
	
	@Column(name = "nr_ano", updatable = false)
	private Integer ano;
	
	@Column(name = "dt_revisao")
	private LocalDate revisao;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "ds_tipo", length = 30)
	private Tipo tipo;
	
	@Column(name = "br_placa", length = 8, unique = true)
	private String placa;

	public Veiculo(Integer codigo, String modelo, Double valor, Integer ano, LocalDate revisao, Tipo tipo,
			String placa) {
		super();
		this.codigo = codigo;
		this.modelo = modelo;
		this.valor = valor;
		this.ano = ano;
		this.revisao = revisao;
		this.tipo = tipo;
		this.placa = placa;
	}

	public Veiculo() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDate getRevisao() {
		return revisao;
	}

	public void setRevisao(LocalDate revisao) {
		this.revisao = revisao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}	
}
