package com.bharath.eshopbackend.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.eshopbackend.dao.UserDao;
import com.bharath.eshopbackend.model.User;
@Component
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) 
	{
		Session session=null;
        try {
        	user.setRole("ROLE_USER");
        	user.setEnabled(true);
            session    =sessionFactory.openSession();
            session.save(user);
        Transaction transaction=    session.beginTransaction();
        transaction.commit();
           return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("catch");
            return false;
        }
        finally {
            session.close();

        }
	}

	public boolean checkLogin(User user) {
		Session session=null;
		try
		{
		 session=sessionFactory.openSession();
		Query query=session.createQuery("from User where email=:em and password=:pw");
		query.setParameter("em",user.getEmail());
		query.setParameter("pw",user.getPassword());
		User user2=(User)query.uniqueResult();
		if(user2==null)
		{
			return false;
		}
		else {
			return true;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
	}

	public User getUser(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where email=:em");
		query.setParameter("em",email);
		User user=(User)query.uniqueResult();
		return user;
	}
	public boolean editUser(User user)
	{
		Session session=null;
		try
		{
		session=sessionFactory.openSession();
		session.update(user);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return true;
		
		}
		catch (Exception e) {
			return false;
		}
		finally {
			session.close();
		}
	}
	
}
