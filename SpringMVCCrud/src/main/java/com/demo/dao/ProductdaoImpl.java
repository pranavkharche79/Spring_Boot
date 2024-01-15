package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductdaoImpl implements Productdao
{
	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Product> getallproducts() {
		return jt.query("select * from products", (rs,num)->{
			Product p=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
			return p;
		});
	}
	
	
	@Override
	public void save(Product p) {
		String str="insert into product values(?,?,?,?)";
		jt.update(str,new Object[] {p.getPid(),
				p.getPname(),p.getPrice(),p.getQty()});
		
	}

	@Override
	public Product findById(int pid) {
		try {
		    return jt.queryForObject("select * from product where pid=?",new Object[] {pid},BeanPropertyRowMapper.newInstance(Product.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public void modifyProduct(Product product) {
		jt.update("update product set pname=?,qty=?,price=? where pid=?",
				new Object[] {product.getPname(),product.getQty(),product.getPrice(),product.getPid()});
		
	}

	@Override
	public void removeById(int id) {
		jt.update("delete from product where pid=?",new Object[] {id});
		
	}    

}
