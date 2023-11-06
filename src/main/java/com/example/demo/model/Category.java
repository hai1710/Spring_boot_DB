package com.example.demo.model;

import java.time.LocalDateTime;

public class Category {
    private int idCategory;
    private int categoryCode;
    private String nameCategory;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Category(int idCategory, int categoryCode, String nameCategory, String description, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.idCategory = idCategory;
        this.categoryCode = categoryCode;
        this.nameCategory = nameCategory;
        this.description = description;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Category() {

    }

    // Getters and setters

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        sb.append("Category ID: ").append(idCategory).append("\n");
        sb.append("Category Code: ").append(categoryCode).append("\n");
        sb.append("Name: ").append(nameCategory).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("Updated Date: ").append(updatedDate).append("\n");
        sb.append("-----------------------------");
        return sb.toString();
    }
}