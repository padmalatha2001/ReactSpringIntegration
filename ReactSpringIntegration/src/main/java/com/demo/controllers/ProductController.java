package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demo.entities.Product;
import com.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	
	private ProductService productService;
	
	
	@RequestMapping(value = "em_findall", method = RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
public ResponseEntity<Iterable<Product>> findAll() {
	try {
		return new ResponseEntity<Iterable<Product>>(
				productService.findAll(), HttpStatus.OK);
	}
	catch(Exception e){
		return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST); 
	}
}
	
	@RequestMapping(value = "em_create", method = RequestMethod.POST,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
			consumes = {MimeTypeUtils.APPLICATION_JSON_VALUE} )
	
public ResponseEntity<Product> create(@RequestBody Product product) {
	try {
		return new ResponseEntity<Product>(
				productService.save(product), HttpStatus.OK);
	}
	catch(Exception e){
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST); 
	}
}
	

	 @DeleteMapping("/em_delete/{id}")
	    public String deleteemployee(@PathVariable int id) {
	        return productService.delete(id);
	    }
	 

	    @PutMapping("/em_update")
	    public Product updateProduct(@RequestBody Product product) {
	        return productService.updateProduct(product);
	    }
	
	
}
