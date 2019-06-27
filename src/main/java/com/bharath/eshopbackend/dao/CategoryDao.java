package com.bharath.eshopbackend.dao;

import java.util.List;

import com.bharath.eshopbackend.model.Category;
public interface CategoryDao {
   boolean saveCategory(Category category);

   boolean deleteCategory(Category category);
   boolean editCategory(Category category);

   Category getCategory(int categoryId);

List<Category>    getCategoryList();

}