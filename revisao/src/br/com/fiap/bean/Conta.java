package br.com.fiap.bean;

import java.math.BigDecimal;
import java.util.Calendar;

public abstract class Conta {
	private String agencia;
	private String numero;
	private Calendar dataAbertura;
	private BigDecimal saldo;
	
	public Conta(String agencia, String numero, Calendar dataAbertura, BigDecimal saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}
	
	public Conta() {
		super();
	}

	public void depositar(BigDecimal valor) {
		this.saldo.add(valor);
	}
	
	public abstract void retirar(BigDecimal valor) throws Exception;
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", dataAbertura=" + 
				dataAbertura.DAY_OF_MONTH + "/" + dataAbertura.MONTH + "/" + dataAbertura.YEAR + ", saldo="
				+ saldo + "]";
	}
}
