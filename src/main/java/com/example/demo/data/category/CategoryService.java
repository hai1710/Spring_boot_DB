package com.example.demo.data.category;

import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCategory(Category category) {
        String query = "INSERT INTO category (category_code, name_category, description, created_date, updated_date) VALUES (?, ?, ?, NOW(), NOW())";
        jdbcTemplate.update(query, category.getCategoryCode(), category.getNameCategory(), category.getDescription());
    }

    @Override
    public void updateCategory(Category category) {
        String query = "UPDATE category SET category_code = ?, name_category = ?, description = ?, updated_date = NOW() WHERE id_category = ?";
        jdbcTemplate.update(query, category.getCategoryCode(),
                category.getNameCategory(), category.getDescription(), category.getIdCategory());
    }

    @Override
    public void deleteCategory(int idCategory) {
        String query = "DELETE FROM category WHERE id_category = ?";
        jdbcTemplate.update(query, idCategory);
    }

    @Override
    public Category findCategoryById(int idCategory) {
        String query = "SELECT * FROM category WHERE id_category = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{idCategory}, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public List<Category> getAllCategories() {
        String query = "SELECT * FROM category";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Category.class));
    }
}