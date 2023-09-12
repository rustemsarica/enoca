package com.rustemsarica.enoca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DynamicTableService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable(String tableName){
        String createTableSQL = "CREATE TABLE " + tableName + " (id SERIAL PRIMARY KEY, data VARCHAR(255))";
        jdbcTemplate.execute(createTableSQL);

    }

    public void insertData(String tableName, String data){
        String insertDataSQL = "INSERT INTO " + tableName + " (data) VALUES (?)";
        jdbcTemplate.update(insertDataSQL, data);
    }

    public Object getTable(String tableName) {
        String getData = "SELECT * FROM " + tableName ;
        return jdbcTemplate.queryForList(getData);
    }

    public Object deleteDataFromTable(String tableName, long dataId) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        return jdbcTemplate.update(query,dataId);
    }
}
