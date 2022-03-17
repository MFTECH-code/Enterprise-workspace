package br.com.fiap.application;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaInvestimento;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
 
public class Program {
	public static void main(String[] args) {
		Conta cc = new ContaCorrente("001", "3399299", Calendar.getInstance(), new BigDecimal(1000), TipoConta.ESPECIAL);
		ContaPoupanca cp = new ContaPoupanca("001", "3399299", Calendar.getInstance(), new BigDecimal(1000), 40);

		
		System.out.println("Operaçoes com conta poupança");
		cp.depositar(new BigDecimal(500));
		System.out.println(cp);
		try {
			cp.retirar(new BigDecimal(500));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(cp);
		
		System.out.println(cp.calculaRetornoInvestimento());
	}
}
