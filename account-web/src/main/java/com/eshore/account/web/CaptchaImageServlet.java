package com.eshore.account.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.eshore.account.service.AccountService;
import com.eshore.account.service.AccountServiceException;

public class CaptchaImageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4530680422741595106L;
	
	private ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		super.init();
		context=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String key=req.getParameter("key");
		if(key==null || key.length()==0){
			resp.sendError(400, "No Captcha Key Found");
		}else{
			try {
				AccountService service=(AccountService)context.getBean("accountService");
				OutputStream out=resp.getOutputStream();
				out.write(service.generateCaptchaImage(key));
				out.close();
			} catch (AccountServiceException e) {
				e.printStackTrace();
				resp.sendError(404, e.getMessage());
			}
		}
	}

}
