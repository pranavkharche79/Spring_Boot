package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
		String str="insert into products(title,description,unitprice,categoryid,unitinstock) values(?,?,?,?,?)";
		jt.update(str,new Object[] {
				p.getTitle(),p.getDesc(),p.getUnit(),p.getCatid(),p.getUnitstock()});
		
	}

	@Override
	public Product findById(int pid) {
		try {
		  Product p = jt.queryForObject("select * from products where productid=?",new Object[] {pid},
		    		(rs,num)->{
		    			Product r=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
		    			return r;
		    		});
		  return p;
			
			//OR
		  
//			SqlRowSet rowSet = jt.queryForRowSet("select * from products where productid=?", new Object[] {pid});
//			Product product = null;
//			while (rowSet.next()) {
//			    product = new Product(rowSet.getInt("productid"), rowSet.getString("title"), rowSet.getString("description"), rowSet.getInt("unitprice"), rowSet.getInt("categoryid"), rowSet.getInt("unitinstock"));
//			}
//			return product;
			
			
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public void modifyProduct(Product p) {
		jt.update("update products set title=?,description=?,unitprice=?,categoryid=?,unitinstock=? where productid=?",
				new Object[] {p.getTitle(),p.getDesc(),p.getUnit(),p.getCatid(),p.getUnitstock(),p.getPid()});
	}

	@Override
	public void removeById(int id) {
		jt.update("delete from products where productid=?",new Object[] {id});
		
	}    

}
