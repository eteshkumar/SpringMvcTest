package com.iris.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Component
@EnableTransactionManagement
@ComponentScan(basePackages={"com.iris"})
public class DbConfig {
	
	/* class for this DataSource which is named as DriverManagerDataSource*/
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		/*Spring @Bean Annotation is applied on a method to specify that it returns a bean to be
		 *  managed by Spring context. Spring Bean annotation is usually declared in Configuration
		 *   classes methods*/
		@Bean(name="dataSource")
		public DataSource getDataSource()   //java.sql
		{
			System.out.println("Im Hello 1");
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUsername("hr");
			dataSource.setPassword("hr");
			System.out.println("Im hello 2");
			return dataSource;
		}
		
		@Bean(name="sessionFactory")  //java.util
		public SessionFactory getSessionFactory()
		{
			
			/*Properties is a class of java.util package which will store the data in
			 * key and value pair*/
			System.out.println("Im hello 3");
			Properties p=new Properties();
			p.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			p.setProperty("hibernate.hbm2ddl.auto","update");
			p.setProperty("hibernate.show_sql", "true");
			
			/*LocalSessionFactoryBuilder is  a class provided by Spring framework which 
			 * will help to build session factory*/
			LocalSessionFactoryBuilder sb=
					new LocalSessionFactoryBuilder(getDataSource());
			sb.addProperties(p);
			sb.scanPackages("com.iris.models");
			SessionFactory sf=sb.buildSessionFactory();
			System.out.println("Im hello 4");
			return sf;
		}

		@Bean(name="HibernateTranscation")
		@Autowired
		public HibernateTransactionManager getHibernateTranscationManager(SessionFactory sessionFactory)
		{
			System.out.println("Im hello 5");
			HibernateTransactionManager txManager=
				new HibernateTransactionManager(sessionFactory);
			System.out.println("Im hello 6");
				return txManager;
		}	
	
	
}
