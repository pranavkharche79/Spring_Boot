package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getallproduct();
	
	void addnewProduct(Product p);

	Product getById(int pid);

	void updateById(Product product);

	void deleteById(int id);

}
