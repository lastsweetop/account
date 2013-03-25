package com.eshore.account.email;

import static org.junit.Assert.assertEquals;

import javax.mail.Message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;

public class AccountEmailServiceTest {
	private GreenMail greenMail;
	
	@BeforeClass
	public void startMailServer(){
		greenMail=new GreenMail(ServerSetupTest.SMTP);
		greenMail.setUser("test@eshore.com", "123456");
		greenMail.start();
	}
	
	@Test
	public void testSendMail() throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService=(AccountEmailService)ctx.getBean("accountEmailService");
		
		String subject="Test Subject";
		String htmlText="<h3>Test</h3>";
		accountEmailService.sendMail("test2@eshore.com", subject, htmlText);
		
		greenMail.waitForIncomingEmail(2000, 1);
		
		Message[] msgs=greenMail.getReceivedMessages();
		assertEquals(1,msgs.length);
		assertEquals(subject,msgs[0].getSubject());
		assertEquals(htmlText,GreenMailUtil.getBody(msgs[0]).trim());
	}
	
	@AfterClass
	public void stopMailServer(){
		greenMail.stop();
	}
}
