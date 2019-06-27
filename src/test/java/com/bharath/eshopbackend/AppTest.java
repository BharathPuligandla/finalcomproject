package com.bharath.eshopbackend;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AppTest 
 {
ApplicationContext applicationContext=new ClassPathXmlApplicationContext("DbConfig.xml");
SessionFactory sessionFactory=(SessionFactory)applicationContext.getBean("sessionFactory");

 }
