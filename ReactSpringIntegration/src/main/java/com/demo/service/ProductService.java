package com.demo.service;

import com.demo.entities.Product;

public interface ProductService {
public Iterable<Product> findAll();

public Product save(Product product);

public String delete(int id);

public Product updateProduct(Product product);
}
