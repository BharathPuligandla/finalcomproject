package com.bharath.eshopbackend.DbConfig;


import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class DbConfig
{
	@Bean(name="dataSource")
	public DataSource getDatasource()
	{
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/bharath");
		basicDataSource.setUsername("bharath");
		basicDataSource.setPassword("bharath");
		return basicDataSource;
	}
	@Bean
	public Properties getProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
		
	}
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getDatasource());
		localSessionFactoryBuilder.addProperties(getProperties());
		localSessionFactoryBuilder.scanPackages("com.bharath");
		return localSessionFactoryBuilder.buildSessionFactory();
		
	}
	@Bean
	 public HibernateTransactionManager getHibernateTransactionManager()
    {
        HibernateTransactionManager transactionManager=new HibernateTransactionManager(getSessionFactory());
        System.out.println(transactionManager);
        return transactionManager;
        
    }
}

