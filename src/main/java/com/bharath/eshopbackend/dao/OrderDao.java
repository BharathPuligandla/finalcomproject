package com.bharath.eshopbackend.dao;

import java.util.List;

import com.bharath.eshopbackend.model.userOrder;

public interface OrderDao
{
	
	boolean saveOrder(userOrder userOrder);
	List<userOrder> getMyOrders(String userName);

}
