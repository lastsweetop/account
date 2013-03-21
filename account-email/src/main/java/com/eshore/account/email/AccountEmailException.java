package com.eshore.account.email;

import javax.mail.MessagingException;

public class AccountEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7461338277415190452L;


	public AccountEmailException(String msg, MessagingException e) {
		super(msg,e);
	}

}
