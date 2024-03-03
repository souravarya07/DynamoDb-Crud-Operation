package com.example.demo.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DynamoDbRepo {
    public void createProductTable() throws Exception;
    public void deleteProductTable(String tableName) throws Exception;
}
