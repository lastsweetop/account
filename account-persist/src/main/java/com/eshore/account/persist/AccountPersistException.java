package com.eshore.account.persist;

/**
 * ClassName: AccountPersistException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2013-4-11 上午9:07:19 <br/>
 *
 * @author wudongdong
 * @version
 * @since JDK 1.6
 */
public class AccountPersistException extends Exception {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long	serialVersionUID	= 7461338277415190452L;

	/**
	 * Creates a new instance of AccountPersistException.
	 * @param msg String
	 * @param e Exception
	 */
	public AccountPersistException(final String msg, final Exception e) {
		super(msg, e);
	}

}
