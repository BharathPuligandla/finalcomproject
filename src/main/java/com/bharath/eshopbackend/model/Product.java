package com.bharath.eshopbackend.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="Prod")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int productId;
private String productName;
private String productDiscription;
private int productPrice;
private String productSupplier;
private String productCategory;
int stock;
@Transient
private MultipartFile productImage;

public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

public MultipartFile getProductImage() {
	return productImage;
}
public void setProductImage(MultipartFile productImage) {
	this.productImage = productImage;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDiscription() {
	return productDiscription;
}
public void setProductDiscription(String productDiscription) {
	this.productDiscription = productDiscription;
}
public int getProductPrice() {
	return productPrice;
}
public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}
public String getProductSupplier() {
	return productSupplier;
}
public void setProductSupplier(String productSupplier) {
	this.productSupplier = productSupplier;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
}
