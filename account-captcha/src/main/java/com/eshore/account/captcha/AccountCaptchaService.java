package com.eshore.account.captcha;

import java.util.List;

/**
 * ClassName: AccountCaptchaService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2013-4-11 上午8:55:32 <br/>
 * @author wudongdong
 * @version
 * @since JDK 1.6
 */
public interface AccountCaptchaService {
	String generateCaptchaKey() throws AccountCaptchaException;

	byte[] generateCaptchaImage(String captchaKey)
			throws AccountCaptchaException;

	boolean validateCaptcha(String captchaKey, String captchaValue)
			throws AccountCaptchaException;

	List<String> getPreDefinedTexts() throws AccountCaptchaException;

	void setPreDefinedTexts(List<String> preDefinedTexts)
			throws AccountCaptchaException;
}
