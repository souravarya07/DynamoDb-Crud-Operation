package com.example.demo.Service;

import com.example.demo.Model.Product;

import java.util.List;

public interface ProductService {

    public void createTable(String tableName);
    public void deleteTable(String tableName);
    public void saveProduct(Product product);
    public Product getProduct(String id, String name);
    public List<Product> getAllProducts();
    public void updateProduct(String id, String name, double quantity);
    public void deleteProduct(String id, String name);

}
