package com.example.demo.data.store;

import com.example.demo.model.Store;

import java.util.List;

public interface IStoreService {
    void addStore(Store store);
    void updateStore(Store store);
    void deleteStore(int idStore);
    Store findStoreById(int idStore);
    List<Store> getAllStores();
}