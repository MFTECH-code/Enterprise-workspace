package br.com.fiap.bean;

import java.math.BigDecimal;
import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento {
	private float taxa;
	private static final float RENDIMENTO = 6.17f;
		
	public ContaPoupanca(String agencia, String numero, Calendar dataAbertura, BigDecimal saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	public ContaPoupanca() {
		super();
	}

	@Override
	public void retirar(BigDecimal valor) throws Exception {
		if (super.getSaldo().compareTo(valor) >= 0) {
			super.setSaldo(super.getSaldo().subtract(valor.add(new BigDecimal(taxa))));
		} else {
			throw new SaldoInsuficienteException("Conta sem saldo suficiente...");
		}
	}

	@Override
	public BigDecimal calculaRetornoInvestimento() {
		return super.getSaldo().multiply(new BigDecimal(RENDIMENTO / 100));
	}

}
