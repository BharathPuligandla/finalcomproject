package com.bharath.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.eshopbackend.dao.SupplierDao;
import com.bharath.eshopbackend.model.Category;
import com.bharath.eshopbackend.model.Product;
import com.bharath.eshopbackend.model.Supplier;
@Component("supDaoimpl")
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
        session.save(supplier);
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

	public boolean deleteSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
    	session.delete(supplier);
    	Transaction transaction=session.beginTransaction();
    	transaction.commit();
    	session.close();
		return false;
	}

	public Supplier getSupplier(int supplierId) {
		Session session=sessionFactory.openSession();
    	Supplier supplier=session.get(Supplier.class,supplierId);
    	session.close();
    	return supplier;
	}

	public List<Supplier> getSupplierList() {
		Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Supplier");
        List<Supplier> supplierList=query.list();
        session.close();
        return supplierList;
	}

	public boolean editSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
        session.update(supplier);
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
