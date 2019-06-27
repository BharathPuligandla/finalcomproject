package com.bharath.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.eshopbackend.dao.ProductDao;
import com.bharath.eshopbackend.model.Category;
import com.bharath.eshopbackend.model.Product;
@Component
public class ProductDaoImpl implements ProductDao
{
	
@Autowired
SessionFactory sessionFactory;
	public boolean saveProduct(Product product) {
		
        Session session=null;
        try
        {
        	session=sessionFactory.openSession();
        	/*if(product.getProductId()==0)
        	{
        		int id=(int)(Math.random()*10000);
        		product.setProductId(id);
        	}*/
        	session.save(product);
            Transaction transaction=session.beginTransaction();
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

	public boolean deleteProduct(Product product) {
		Session session=sessionFactory.openSession();
    	session.delete(product);
    	Transaction transaction=session.beginTransaction();
    	transaction.commit();
    	session.close();
    	return false;
	}

	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
    	Product product=session.get(Product.class,productId);
    	session.close();
    	return product;
	}

	public List<Product> getProductList() {
		Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Product");
       
        List<Product> productList=query.list();
        session.close();
        return productList;
	}
	public List<Product> getProductList(Category category) {
		Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Product where productCategory=:pc");
       query.setParameter("pc",category.getCategoryName());
        List<Product> productList=query.list();
        session.close();
        return productList;
	}

	public boolean editProduct(Product product) {
		Session session=sessionFactory.openSession();
        session.saveOrUpdate(product);
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
