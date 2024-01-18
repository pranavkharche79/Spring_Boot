package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;

@Repository
public class LogindaoImpl implements Logindao 
{
	@Autowired
	JdbcTemplate jt;

	@SuppressWarnings("deprecation")
	@Override
	public MyUser validate(String uname, String pass) {
		System.out.println(uname+"  "+pass);
		try {
			String str="select username,password,role from login where username=? and password=?";
			return jt.queryForObject(str,new Object[] {uname,pass},BeanPropertyRowMapper.newInstance(MyUser.class));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("not found"+e.getMessage());
			return null;
		}
	}
	
}
