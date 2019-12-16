package com.iris.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DbConfig;
import com.iris.daos.ProductDao;
import com.iris.models.Product;

public class ProductTest {
	
	private static ProductDao Obj;

	
	@BeforeClass
	public static void init() {
		System.out.println("Im m  init start");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

		Obj = context.getBean(ProductDao.class, "productDao");
		
		System.out.println("Im m init end : "+Obj);
	}

	@Test
	@Ignore
	public void addProductTest() {
		Product p = new Product();
		p.setProductName("Trouser");
		p.setPrice(2000);

		boolean b=Obj.addProduct(p);
		assertTrue("problem in adding product", b);
	}
	@Test
	public void getProductByidTest() {
		Product pObj=Obj.getProductById(1);
		assertNotNull("Product with given id does not exist",pObj);
	}
	@Test
	public void getAllProductTest() {
		List<Product> list=Obj.getAllProducts();
		Assert.assertNotEquals("Products not found", list.size(),0);
	}
}
