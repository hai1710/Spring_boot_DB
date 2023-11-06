package com.example.demo.data.store;

import com.example.demo.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements IStoreService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StoreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addStore(Store store) {
        String query = "INSERT INTO store (store_code, name_store, address) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, store.getStoreCode(), store.getNameStore(), store.getAddress());
    }

    @Override
    public void updateStore(Store store) {
        String query = "UPDATE store SET store_code = ?, name_store = ?, address = ? WHERE id_store = ?";
        jdbcTemplate.update(query, store.getStoreCode(), store.getNameStore(), store.getAddress(), store.getIdStore());
    }

    @Override
    public void deleteStore(int idStore) {
        String query = "DELETE FROM store WHERE id_store = ?";
        jdbcTemplate.update(query, idStore);
    }

    @Override
    public Store findStoreById(int idStore) {
        String query = "SELECT * FROM store WHERE id_store = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{idStore}, new BeanPropertyRowMapper<>(Store.class));
    }

    @Override
    public List<Store> getAllStores() {
        String query = "SELECT * FROM store";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Store.class));
    }
}