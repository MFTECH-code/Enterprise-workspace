package br.com.fiap.relacionamentos.entities;

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

@Entity
@Table(name = "TB_JOGADOR")
@SequenceGenerator(sequenceName = "sq_jogador", name = "sq_jogador", allocationSize = 1)
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_jogador")
	@Column(name = "cd_jogador")
	private Integer codigo;
	
	@Column(name = "nm_jogador", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "nr_camisa", nullable = false)
	private Integer camisa;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "ds_posicao", nullable = false)
	private PosicaoJogador posicao;
	
	@Column(name = "vl_salario", length = 10, scale = 2, nullable = false)
	private Double salario;
	
	@Lob
	@Column(name = "ft_jogador")
	private Byte[] foto;

	public Jogador(Integer codigo, String nome, Integer camisa, PosicaoJogador posicao, Double salario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.camisa = camisa;
		this.posicao = posicao;
		this.salario = salario;
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

	public Integer getCamisa() {
		return camisa;
	}

	public void setCamisa(Integer camisa) {
		this.camisa = camisa;
	}

	public PosicaoJogador getPosicao() {
		return posicao;
	}

	public void setPosicao(PosicaoJogador posicao) {
		this.posicao = posicao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}
}
