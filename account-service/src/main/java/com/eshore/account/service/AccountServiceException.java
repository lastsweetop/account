package com.eshore.account.service;

import com.eshore.account.captcha.AccountCaptchaException;

public class AccountServiceException extends Exception {

	public AccountServiceException(String string,Exception e) {
		super(string,e);
	}

	public AccountServiceException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4396329970630444552L;

	
}
