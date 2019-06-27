package com.bharath.eshopbackend.dao;

import java.util.List;

import com.bharath.eshopbackend.model.Category;
import com.bharath.eshopbackend.model.Product;

public interface ProductDao
{
boolean saveProduct(Product product);
    
    boolean deleteProduct(Product product);
    boolean editProduct(Product product);
    Product getProduct(int productId);
    List<Product>    getProductList(Category category); 
   List<Product>    getProductList();
}
