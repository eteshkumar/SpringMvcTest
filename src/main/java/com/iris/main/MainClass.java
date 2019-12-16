package com.iris.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DbConfig;

public class MainClass {
	public static void main(String []args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DbConfig.class);
	}

}
