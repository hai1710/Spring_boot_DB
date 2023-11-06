package com.example.demo.data.category;



import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int idCategory);
    Category findCategoryById(int idCategory);
    List<Category> getAllCategories();
}
