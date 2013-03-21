package com.eshore.account.persist;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountPersistServiceTest {
	
	private AccountPersistService service;

	@Before
	public void prepare() throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("account-persist.xml");
		service=(AccountPersistService)ctx.getBean("accountPersistService");
	}
	
	@Test
	public void testReadAccount() throws Exception {
		Account account=service.readAccount("sweetop");
		assertNotNull(account);
		assertEquals("sweetop",account.getId());
		assertEquals("Sweetop Wu",account.getName());
		assertEquals("sweetop@189.cn",account.getEmail());
		assertEquals("123456789",account.getPassword());
		assertTrue(account.isActivated());
	}

}
