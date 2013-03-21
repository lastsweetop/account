package com.eshore.account.persist;

public class AccountPersistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7461338277415190452L;

	public AccountPersistException(String msg, Exception e) {
		super(msg, e);
	}

}
