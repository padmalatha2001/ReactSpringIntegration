package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;


import com.demo.repositories.*;
import com.demo.entities.*;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
    public void run(String...args) throws Exception {

        this.productRepository.save(new Product("Ramesh", "IT", "2000-02-02"));
        this.productRepository.save(new Product("Tom", "Civil", "1999-01-09"));
        this.productRepository.save(new Product("Tony", "Chemical", "2001-08-02"));
    }

}
