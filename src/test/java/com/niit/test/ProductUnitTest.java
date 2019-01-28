package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;


public class ProductUnitTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Lee Shirt");
		product.setProductDesc("Lee Brand T Shirts");
		product.setPrice(1600);
		product.setStock(45);
		product.setCategoryId(3);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}
}
