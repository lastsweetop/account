package com.eshore.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * ClassName: AccountEmailServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2013-4-11 下午3:12:32 <br/>
 * @author wudongdong
 * @version
 */
public class AccountEmailServiceImpl implements AccountEmailService {

	/**
	 * javaMailSender:TODO(用一句话描述这个变量表示什么).
	 *
	 * @since JDK 1.6
	 */
	private JavaMailSender	javaMailSender;

	/**
	 * systemEmail:TODO(用一句话描述这个变量表示什么).
	 *
	 * @since JDK 1.6
	 */
	private String			systemEmail;

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 *
	 * @param to
	 *            String
	 * @param subject
	 *            String
	 * @param htmlText
	 *            String
	 * @throws AccountEmailException  if has error
	 * @see com.eshore.account.email.AccountEmailService#sendMail(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void sendMail(final String to, final String subject,
			final String htmlText) throws AccountEmailException {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);

			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(htmlText, true);

			javaMailSender.send(msg);

		} catch (MessagingException e) {
			throw new AccountEmailException("Faild to send mail", e);
		}
	}

	/**
	 * getSystemEmail:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author wudongdong
	 * @return systemEmail
	 * @since JDK 1.6
	 */
	public final String getSystemEmail() {
		return systemEmail;
	}

	/**
	 * setSystemEmail:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author wudongdong
	 * @param newSystemEmail String
	 * @since JDK 1.6
	 */
	public void setSystemEmail(final String newSystemEmail) {
		this.systemEmail = newSystemEmail;
	}

	/**
	 * getJavaMailSender:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author wudongdong
	 * @return javaMailSender JavaMailSender
	 * @since JDK 1.6
	 */
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	/**
	 * setJavaMailSender:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author wudongdong
	 * @param newJavaMailSender
	 *            JavaMailSender
	 * @since JDK 1.6
	 */
	public void setJavaMailSender(final JavaMailSender newJavaMailSender) {
		this.javaMailSender = newJavaMailSender;
	}

}
