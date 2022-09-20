package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public Iterable<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	@Override
	public String delete(int id) {
		productRepository.deleteById(id);
        return "employee removed !! " + id;
    }
	
	@Override
	public Product updateProduct(Product product) 
	{
	        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
	        existingProduct.setName(product.getName());
	        existingProduct.setDepartment(product.getDepartment());
	        existingProduct.setDob(product.getDob());
	        return productRepository.save(existingProduct);
	    }

}
