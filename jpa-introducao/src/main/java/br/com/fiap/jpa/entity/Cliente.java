package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="tb_cliente")
public class Cliente {
	
	@Id
	@SequenceGenerator(name="sq_tb_cliente", sequenceName="sq_tb_cliente", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_tb_cliente")
	@Column(name="cd_id", nullable=false)
	private Integer id;
	
	@Column(name="ds_name", nullable=false, length=80)
	private String nome;
	
	@Column(name="ds_email", unique=true, length=100)
	private String email;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro", nullable=false, updatable=false)
	private Calendar dataCadastro;

	@Column(name="st_ativo", insertable=false)
	private Boolean ativo;
	
	@Column(name="vl_credito")
	private BigDecimal credio;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@Transient
	private Integer idade;
	
	@Lob
	@Column(name="fl_foto_cnh")
	private byte[] fotoCnh;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gn_genero", length=40)
	private Genero genero;

	public Cliente(String nome, String email, BigDecimal credio,
			LocalDate dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.credio = credio;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public BigDecimal getCredio() {
		return credio;
	}

	public void setCredio(BigDecimal credio) {
		this.credio = credio;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public byte[] getFotoCnh() {
		return fotoCnh;
	}

	public void setFotoCnh(byte[] fotoCnh) {
		this.fotoCnh = fotoCnh;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
