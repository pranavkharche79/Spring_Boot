package com.demo.service;

import java.util.List;
import java.util.Optional;

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
		return pdao.findAll();
	}

	@Override
	public void addnewProduct(Product p) {
		pdao.save(p);
		
	}

	@Override
	public Product getById(int pid) {
		 Optional<Product> op=pdao.findById(pid);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
	}

	@Override
	public void updateById(Product pro) {
		Optional<Product> op=pdao.findById(pro.getPid());
		if(op.isPresent()) {
			Product p=op.get();
			p.setTitle(pro.getTitle());
			p.setDesc(null);
			p.setUnit(pro.getUnit());
			p.setCatid(pro.getCatid());
			p.setUnitstock(pro.getUnitstock());
			pdao.save(p);
			
		}
		
	}

	@Override
	public void deleteById(int id) {
		pdao.deleteById(id);
		
	}
	
}
