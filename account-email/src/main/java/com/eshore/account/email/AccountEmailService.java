package com.eshore.account.email;

/**
 * ClassName: AccountEmailService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2013-4-10 下午7:46:26 <br/>
 * @author wudongdong
 * @version
 * @since JDK 1.6
 */
public interface AccountEmailService {

	/**
	 * sendMail:(这里用一句话描述这个方法的作用). <br/>
	 * @author wudongdong
	 * @param to String
	 * @param subject String
	 * @param htmlText String
	 * @throws AccountEmailException
	 * @since JDK 1.6
	 */
	void sendMail(String to, String subject, String htmlText)
			throws AccountEmailException;

}
