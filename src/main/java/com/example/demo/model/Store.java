package com.example.demo.model;

import java.time.LocalDateTime;

public class Store {
    private int idStore;
    private int storeCode;
    private String nameStore;
    private String address;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Store() {
    }

    public Store(int idStore, int storeCode, String nameStore, String address, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.idStore = idStore;
        this.storeCode = storeCode;
        this.nameStore = nameStore;
        this.address = address;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    // Getters and setters

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public int getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(int storeCode) {
        this.storeCode = storeCode;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        sb.append("Store ID: ").append(idStore).append("\n");
        sb.append("Store Code: ").append(storeCode).append("\n");
        sb.append("Name: ").append(nameStore).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("Updated Date: ").append(updatedDate).append("\n");
        sb.append("-----------------------------");
        return sb.toString();
    }
}