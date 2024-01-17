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
	
	
	@GetMapping("/addprod")
	public String displayaddform(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) 
		   return "addprod";
		return "redirect:/login/";
	}
	
	@PostMapping("/insertprod")
	public ModelAndView insertProduct(@RequestParam String title,@RequestParam String desc,@RequestParam int price,@RequestParam int cid,@RequestParam int stock) {
		Product p=new Product(title,desc,price,cid,stock);
		pses.addnewProduct(p);
		return new ModelAndView("redirect:/products");
		
	}
	
	@GetMapping("/editprod/{pid}")
	public ModelAndView editProduct(@PathVariable int pid) {
		Product p=pses.getById(pid);
		System.out.println(p);
		return new ModelAndView("updateprod","p",p);
		
	}
	
	@PostMapping("/update")
	public ModelAndView updateProdut(@RequestParam int pid,@RequestParam String title,@RequestParam String desc,@RequestParam int price,@RequestParam int cid,@RequestParam int stock) {
		pses.updateById(new Product(pid,title,desc,price,cid,stock));
		return new ModelAndView("redirect:/products");
	}
	
	@GetMapping("deleteprod/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		pses.deleteById(id);
		return new ModelAndView("redirect:/products");
	}
	
	
}
