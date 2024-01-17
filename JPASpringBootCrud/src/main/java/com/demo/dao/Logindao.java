package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;

@Repository
public interface Logindao extends JpaRepository<MyUser, String> {

	@Query(value="select username,password,role from login where username=? and password=?",nativeQuery = true)
	MyUser validate(String uname, String pass);


}
