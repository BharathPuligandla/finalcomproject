package com.bharath.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.eshopbackend.dao.OrderDao;
import com.bharath.eshopbackend.model.userOrder;
@Component
public class OrderDaoImpl implements OrderDao
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean saveOrder(userOrder userOrder)
	{
		 System.out.println(sessionFactory);
	        Session session=sessionFactory.openSession();
	        session.save(userOrder);
	        Transaction transaction=session.beginTransaction();
	        transaction.commit();
	        try
	        {
	       
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

	public List<userOrder> getMyOrders(String userName) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from userOrder where user.email=:un");
		query.setParameter("un",userName);
		List<userOrder> userOrders=query.list();
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return userOrders;
	}

}
