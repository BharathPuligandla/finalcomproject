package com.bharath.eshopbackend.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.eshopbackend.dao.CategoryDao;
import com.bharath.eshopbackend.model.Category;


@Component("cateDaoImpl")
public class CategoryDaoimpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;
    public boolean saveCategory(Category category)
    {
        System.out.println(sessionFactory);
        Session session=sessionFactory.openSession();
       /* if(category.getCategoryId()==0)
        {
        int id=(int)(Math.random()*10000);
        category.setCategoryId(id);
        }*/
        session.save(category);
        Transaction transaction=session.beginTransaction();
        try
        {
        transaction.commit();
        return true;
        }
    catch(Exception e)
    {
        return false;    
    }
    finally {
        session.close();
    }    
    }

    public boolean deleteCategory(Category category) {
    	Session session=sessionFactory.openSession();
    	session.delete(category);
    	Transaction transaction=session.beginTransaction();
    	transaction.commit();
    	session.close();
    	return false;
    }

    public Category getCategory(int categoryId) {
    	Session session=sessionFactory.openSession();
    	Category category=session.get(Category.class,categoryId);
    	session.close();
    	return category;
    }

    public List<Category> getCategoryList() {
    	System.out.println("before session");
    	Session session=sessionFactory.openSession();
    	System.out.println("after session");
        Query query=session.createQuery("from Category");
        System.out.println("after query");
        List<Category> categoryList=query.list();
        System.out.println("after list");
        session.close();
        return categoryList;
    }

	public boolean editCategory(Category category) {
		 System.out.println(sessionFactory);
	        Session session=sessionFactory.openSession();
	        session.update(category);
	        Transaction transaction=session.beginTransaction();
	        try
	        {
	        transaction.commit();
	        return true;
	        }
	    catch(Exception e)
	    {
	        return false;    
	    }
	    finally {
	        session.close();
	    }    
		
	}

}
