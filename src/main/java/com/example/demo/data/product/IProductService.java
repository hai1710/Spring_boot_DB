package com.example.demo.data.product;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int idProduct);
    Product findProductById(int idProduct);
    List<Product> getAllProducts();
}
