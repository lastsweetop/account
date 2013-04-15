package com.eshore.account.email;

import javax.mail.MessagingException;

/**
 * ClassName: AccountEmailException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2013-4-11 上午8:19:24 <br/>
 *
 * @author wudongdong
 * @version
 * @since JDK 1.6
 */
public class AccountEmailException extends Exception {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 *
	 * @since JDK 1.6
	 */
	private static final long	serialVersionUID	= 7461338277415190452L;

	/**
	 * Creates a new instance of AccountEmailException.
	 *
	 * @param msg String
	 * @param e MessagingException
	 */
	public AccountEmailException(final String msg, final MessagingException e) {
		super(msg, e);
	}

}
