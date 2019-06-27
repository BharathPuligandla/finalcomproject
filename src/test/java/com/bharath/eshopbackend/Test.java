package com.bharath.eshopbackend;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bharath.eshopbackend.daoimpl.CategoryDaoimpl;
import com.bharath.eshopbackend.model.Category;

public class Test
{
	static AnnotationConfigApplicationContext configApplicationContext;
	CategoryDaoimpl  categoryDaoImpl;
	@BeforeClass
	public static void test1()
	{
		configApplicationContext=new AnnotationConfigApplicationContext();
		System.out.println("before class");
		 configApplicationContext.scan("com.bharath.eshopbackend");
	        configApplicationContext.refresh();
	}
	@org.junit.Test
    public void test3()
    {
        
       
         categoryDaoImpl=(CategoryDaoimpl)configApplicationContext.getBean("cateDaoImpl");
      System.out.println(categoryDaoImpl);
      Category category=new Category();
      category.setCategoryId(1239);
      category.setCategoryDescription("abc");
      category.setCategoryName("bba");
      assertEquals("jnkjn ",true,categoryDaoImpl.saveCategory(category));
    
    }
	@org.junit.Test
	public void test2()
	{
		  categoryDaoImpl=(CategoryDaoimpl)configApplicationContext.getBean("cateDaoImpl");
	      System.out.println(categoryDaoImpl);
	      Category category=new Category();
	      category.setCategoryId(1239);
	      category.setCategoryDescription("abc");
	      category.setCategoryName("bba");
	      assertEquals("jnkjn ",false,categoryDaoImpl.saveCategory(category));	
	}
}
