package br.com.fiap.bean;

import java.math.BigDecimal;
import java.util.Calendar;

public class ContaCorrente extends Conta {
	private TipoConta tipoConta;
		
	public ContaCorrente(String agencia, String numero, Calendar dataAbertura, BigDecimal saldo, TipoConta tipoConta) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipoConta = tipoConta;
	}
		
	public ContaCorrente() {
		super();
	}

	@Override
	public void retirar(BigDecimal valor) throws Exception {
		BigDecimal operacao = super.getSaldo().subtract(valor);
		
		if (tipoConta.equals(TipoConta.COMUM)) {
			if (super.getSaldo().compareTo(valor) == -1) {
				throw new SaldoInsuficienteException("Tipo de conta não possui cheque especial...");
			}			
		} 			
		
		super.setSaldo(operacao);
	}
}
