package br.com.fiap.jpa.exception;

public class TransactionExcepion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TransactionExcepion() {
		super("Erro ao realizar transa��o");
	}
	
	public TransactionExcepion(String msg) {
		super(msg);
	}

}
