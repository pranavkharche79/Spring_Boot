package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.demo.model.MyUser;

public class TestHello {

	public static void main(String[] args) {
		//BeanFactory bc=new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyUser user1=(MyUser) ctx.getBean("u1");
		System.out.println(user1);
	}

}