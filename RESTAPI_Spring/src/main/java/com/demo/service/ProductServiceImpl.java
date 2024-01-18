package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.Productdao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	Productdao pdao;

	@Override
	public List<Product> getallproduct() {
		return pdao.getallproducts();
	}

	@Override
	public void addnewProduct(Product p) {
		pdao.save(p);
		
	}

	@Override
	public Product getById(int pid) {
		return pdao.findById(pid);
	}

	@Override
	public void updateById(Product product) {
		pdao.modifyProduct(product);
		
	}

	@Override
	public void deleteById(int id) {
		pdao.removeById(id);
		
	}
	
}
