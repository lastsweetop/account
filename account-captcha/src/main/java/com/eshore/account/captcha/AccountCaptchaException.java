package com.eshore.account.captcha;

import java.io.IOException;

public class AccountCaptchaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7304491145334088767L;

	public AccountCaptchaException(String string) {
		super(string);
	}

	public AccountCaptchaException(String string, IOException e) {
		super(string, e);
	}


}
