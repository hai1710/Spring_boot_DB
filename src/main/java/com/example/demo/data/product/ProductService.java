package com.example.demo.data.product;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addProduct(Product product) {
        String query = "INSERT INTO product (product_code, product_name, price, description, image, quantity_in_stock, quantity_sold, id_store, id_category, created_date, updated_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, product.getProductCode(), product.getProductName(), product.getPrice(), product.getDescription(),
                product.getImage(), product.getQuantityInStock(), product.getQuantitySold(), product.getIdStore(), product.getIdCategory(),
                product.getCreatedDate(), product.getUpdatedDate());
    }

    @Override
    public void updateProduct(Product product) {
        String query = "UPDATE product SET product_code = ?, product_name = ?, price = ?, description = ?, image = ?, " +
                "quantity_in_stock = ?, quantity_sold = ?, id_store = ?, id_category = ?, created_date = ?, updated_date = ? " +
                "WHERE id_product = ?";
        jdbcTemplate.update(query, product.getProductCode(), product.getProductName(), product.getPrice(), product.getDescription(),
                product.getImage(), product.getQuantityInStock(), product.getQuantitySold(), product.getIdStore(), product.getIdCategory(),
                product.getCreatedDate(), product.getUpdatedDate(), product.getIdProduct());
    }

    @Override
    public void deleteProduct(int idProduct) {
        String query = "DELETE FROM product WHERE id_product = ?";
        jdbcTemplate.update(query, idProduct);
    }

    @Override
    public Product findProductById(int idProduct) {
        String query = "SELECT * FROM product WHERE id_product = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{idProduct}, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public List<Product> getAllProducts() {
        String query = "SELECT * FROM product";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class));
    }
}