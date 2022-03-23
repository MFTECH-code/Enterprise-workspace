package br.com.fiap.jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tb_empresa")
public class Empresa {
	
	@Id
	@SequenceGenerator(name="sq_tb_empresa", sequenceName="sq_tb_empresa", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_tb_empresa")
	@Column(name="cd_empresa", nullable=false, insertable=false, updatable=false)
	private Integer id;
	
	@Column(name="nm_nome", nullable=false, length=100)
	private String name;
	
	@Column(name="nm_cnpj", nullable=false, length=20 , unique=true, updatable=false)
	private String cnpj;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tp_empresa", nullable=false, updatable=false, length=30)
	private TipoEmpresa tipoEmpresa;
	
	@CreationTimestamp
	@Column(name="dt_cadastro", nullable=false, updatable=false)
	private LocalDateTime dataCadastro;
	
	@Column(name="dt_fundacao")
	private LocalDate dataFundacao;
	
	@Lob
	@Column(name="fl_contrato_social")
	private byte[] contratoSocial;
	
	@Column(name="st_ativo", insertable=false)
	private Boolean ativo;
	
	@Transient
	private Integer quantidadeFuncionarios;

	public Integer getId() {
		return id;
	}
	
	public Empresa(String name, String cnpj, TipoEmpresa tipoEmpresa,
			LocalDate dataFundacao) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.tipoEmpresa = tipoEmpresa;
		this.dataFundacao = dataFundacao;
	}

	public Empresa() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public byte[] getContratoSocial() {
		return contratoSocial;
	}

	public void setContratoSocial(byte[] contratoSocial) {
		this.contratoSocial = contratoSocial;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(Integer quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}
}
