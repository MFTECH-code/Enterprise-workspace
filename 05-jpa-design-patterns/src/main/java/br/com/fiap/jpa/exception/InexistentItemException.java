package br.com.fiap.jpa.exception;

public class InexistentItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InexistentItemException() {
		super("Item inexistente na tabela");
	}
	
	public InexistentItemException(String msg) {
		super(msg);
	}

}
