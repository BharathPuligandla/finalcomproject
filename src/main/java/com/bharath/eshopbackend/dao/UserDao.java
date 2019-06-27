package com.bharath.eshopbackend.dao;

import com.bharath.eshopbackend.model.User;

public interface UserDao 
{

	 public boolean addUser(User user);
	 public boolean editUser(User user);
	 public boolean checkLogin(User user);
	 public User getUser(String email);
}
