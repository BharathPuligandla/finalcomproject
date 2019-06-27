package com.bharath.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.eshopbackend.dao.CartDao;
import com.bharath.eshopbackend.model.Cart;
import com.bharath.eshopbackend.model.Product;
@Component
public class CartDaoImpl implements CartDao
{
@Autowired
SessionFactory sessionFactory;

	public boolean deleteCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.delete(cart);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return false;
	}

	public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class,cartId);
		session.close();
		return cart;
	}

	public List<Cart> getCartList(String userName)
	{
		Session session=sessionFactory.openSession();
		   Query query=session.createQuery("from Cart where userName=:em");
		   query.setParameter("em", userName);
		    List<Cart> cartlist=query.list();
		    for(Cart cartdata:cartlist)
		    {
		        System.out.println(cartdata.getProductId());
		        
		    }
		    session.close();
		    return cartlist;
	}

		public boolean saveCart(Cart cart) {
		org.hibernate.Session session=sessionFactory.openSession();
		/*if(cart.getCartId()==0)
        {
        int id=(int)(Math.random()*10000);
        cart.setCartId(id);
        }*/
		 
	    session.save(cart);
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

	public boolean editCart(Cart cart) {

		org.hibernate.Session session=sessionFactory.openSession();
		 int quantity;
		 String userName;
		 userName=cart.getUserName();
		 quantity=cart.getQuantity();
		 cart.setQuantity(quantity);
		 cart.setUserName(userName);
		cart.setProductId(cart.getProductId());
		cart.setProductName(cart.getProductName());
	    cart.setProductPrice(cart.getProductPrice());
	    cart.setProductSupplier(cart.getProductSupplier());
	    cart.setTotalPrice(cart.getProductPrice()*cart.getQuantity());
	    session.update(cart);
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
