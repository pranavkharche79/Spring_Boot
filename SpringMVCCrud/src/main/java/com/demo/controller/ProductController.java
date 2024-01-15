package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService pses;
	
	@GetMapping("/products")
	public ModelAndView getallproducts(HttpSession ses)
	{
		
		MyUser u=(MyUser) ses.getAttribute("user");
		if(u!=null) {
			List<Product> plist= pses.getallproduct();
			System.out.println(plist);
			   return new ModelAndView("displayproducts","plist",plist);
		}
			return new ModelAndView("redirect:/login");
	}
	
	
	@GetMapping("/addproduct")
	public String displayaddform(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) 
		   return "addproduct";
		return "redirect:/login/"; 
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct() {
		Product p=new Product();
		pses.addnewProduct(p);
		return new ModelAndView("redirect:/products");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int pid) {
		Product p=pses.getById(pid);
		return new ModelAndView("editProduct","p",p);
		
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProdut() {
		pses.updateById(new Product());
		return new ModelAndView("redirect:/products");
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		pses.deleteById(id);
		return new ModelAndView("redirect:/products");
	}
	
	
}
