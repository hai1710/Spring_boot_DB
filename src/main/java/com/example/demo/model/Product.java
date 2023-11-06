package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private int idProduct;
    private int productCode;
    private String productName;
    private BigDecimal price;
    private String description;
    private String image;
    private int quantityInStock;
    private int quantitySold;
    private int idStore;
    private int idCategory;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Product(int idProduct, int productCode, String productName, BigDecimal price, String description, String image, int quantityInStock, int quantitySold, int idStore, int idCategory, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.idProduct = idProduct;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.quantityInStock = quantityInStock;
        this.quantitySold = quantitySold;
        this.idStore = idStore;
        this.idCategory = idCategory;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Product() {

    }

    // Getters and setters

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product ID: ").append(idProduct).append("\n");
        sb.append("Product Code: ").append(productCode).append("\n");
        sb.append("Name: ").append(productName).append("\n");
        sb.append("Price: ").append(price).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Image: ").append(image).append("\n");
        sb.append("Quantity in Stock: ").append(quantityInStock).append("\n");
        sb.append("Quantity Sold: ").append(quantitySold).append("\n");
        sb.append("Store ID: ").append(idStore).append("\n");
        sb.append("Category ID: ").append(idCategory).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("Updated Date: ").append(updatedDate).append("\n");
        sb.append("-----------------------------");
        return sb.toString();
    }
}