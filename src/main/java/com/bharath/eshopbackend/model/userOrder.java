package com.bharath.eshopbackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class userOrder
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private int grandTotal;
@ManyToOne(cascade = CascadeType.ALL)
private User user;
@ManyToOne(cascade = CascadeType.ALL)
private ShippingAddress shippingAddress;
@Column
private Date date;

public ShippingAddress getShippingAddress() {
	return shippingAddress;
}
public void setShippingAddress(ShippingAddress shippingAddress) {
	this.shippingAddress = shippingAddress;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getGrandTotal() {
	return grandTotal;
}
public void setGrandTotal(int grandTotal) {
	this.grandTotal = grandTotal;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
