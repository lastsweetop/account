package com.eshore.account.persist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPersistServiceTest {

	private AccountPersistService service;

	@BeforeClass
	public void prepare() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"account-persist.xml");
		service = (AccountPersistService) ctx.getBean("accountPersistService");
	}

	@Test
	public void testReadAccount() throws Exception {
		Account account = service.readAccount("sweetop");
		assertNotNull(account);
		assertEquals("sweetop", account.getId());
		assertEquals("Sweetop Wu", account.getName());
		assertEquals("sweetop@189.cn", account.getEmail());
		assertEquals("123456789", account.getPassword());
		assertTrue(account.isActivated());
	}

}
