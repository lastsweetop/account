package com.eshore.account.captcha;

import java.io.IOException;

/**
 * ClassName: AccountCaptchaException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2013-4-11 上午8:50:57 <br/>
 *
 * @author wudongdong
 * @version
 * @since JDK 1.6
 */
public class AccountCaptchaException extends Exception {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 *
	 * @since JDK 1.6
	 */
	private static final long	serialVersionUID	= -7304491145334088767L;

	/**
	 * Creates a new instance of AccountCaptchaException.
	 *
	 * @param string
	 *            String
	 */
	public AccountCaptchaException(final String string) {
		super(string);
	}

	/**
	 * Creates a new instance of AccountCaptchaException.
	 *
	 * @param string
	 *            String
	 * @param e
	 *            IOException
	 */
	public AccountCaptchaException(final String string, final IOException e) {
		super(string, e);
	}

}
