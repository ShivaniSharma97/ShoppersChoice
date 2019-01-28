package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

public class UserUnitTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("vinod");
		user.setPassword("pass123");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Vinod Kumar");
		user.setCustomerAddr("Mumbai");
		
		assertTrue("Problem in adding User:",userDAO.registerUser(user));
	}
}
