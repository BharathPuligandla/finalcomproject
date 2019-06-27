package com.bharath.eshopbackend.dao;

import java.util.List;

import com.bharath.eshopbackend.model.Supplier;

public interface SupplierDao 
{
		boolean saveSupplier(Supplier supplier);
		    
		    boolean deleteSupplier(Supplier supplier);
		    boolean editSupplier(Supplier supplier);
		    Supplier getSupplier(int supplierId);
		    
		   List<Supplier>    getSupplierList();
}

