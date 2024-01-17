package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService lservice;
	
	@GetMapping("/")
	public String Login()
	{
		return "login";
	}
	
	@GetMapping("/SpringMVCCrud/")
	public String Login(HttpSession ses)
	{
		ses.invalidate();
		return "redirect:/login";
	}
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String uname,@RequestParam String pass,HttpSession ses)
	{
		MyUser user=lservice.validate(uname,pass);
		if(user!=null)
		{
			ses.setAttribute("user", user);
			if(user.getRole().equals("admin"))
			{
				System.out.println("inside admin");
				return new ModelAndView("redirect:/products");
			}
			else 
			{
				String a="You are a User";
				return new ModelAndView("login","s",a);
			}
		}
		else {
			String s="Wrong credentials, pls renter";
			return new ModelAndView("login","s",s);
		}
	
	}
	
}
