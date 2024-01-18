package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pses;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getallproducts(HttpSession ses)
	{
			List<Product> plist= pses.getallproduct();
			System.out.println(plist);
			   return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getallproducts(@PathVariable int pid){
		Product p=pses.getById(pid);
		if(p!=null)
		   return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> addproduct(@RequestBody Product p){
		System.out.println("addprod="+p);
		pses.addnewProduct(p);
		return ResponseEntity.ok("Data added successfully");
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p){
		pses.updateById(p);
		return ResponseEntity.ok("Data modified successfully");
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid){
		pses.deleteById(pid);
		return ResponseEntity.ok("Data deleted successfully");
	}
	
	
}
