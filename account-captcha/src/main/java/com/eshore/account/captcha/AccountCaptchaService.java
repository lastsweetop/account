package com.eshore.account.captcha;

import java.util.List;

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
