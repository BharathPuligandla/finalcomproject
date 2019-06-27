package com.bharath.eshopbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sup")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int supplierId;
private String supplierName;
public String getSupplierAddress() {
	return supplierAddress;
}
public void setSupplierAddress(String supplierAddress) {
	this.supplierAddress = supplierAddress;
}
private String supplierDiscription;
private String supplierAddress;
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public String getSupplierDiscription() {
	return supplierDiscription;
}
public void setSupplierDiscription(String supplierDiscription) {
	this.supplierDiscription = supplierDiscription;
}

}
