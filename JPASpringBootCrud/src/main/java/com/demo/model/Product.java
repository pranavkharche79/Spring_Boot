package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String title;
	private String description;
	private int unit;
	private int catid;
	private int unitstock;
	public Product(int pid, String title, String description, int unit, int catid, int unitstock) {
		super();
		this.pid = pid;
		this.title = title;
		this.description = description;
		this.unit = unit;
		this.catid = catid;
		this.unitstock = unitstock;
	}
	public Product(String title, String description, int unit, int catid, int unitstock) {
		super();
		this.title = title;
		this.description = description;
		this.unit = unit;
		this.catid = catid;
		this.unitstock = unitstock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getUnitstock() {
		return unitstock;
	}
	public void setUnitstock(int unitstock) {
		this.unitstock = unitstock;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", title=" + title + ", description=" + description + ", unit=" + unit + ", catid=" + catid
				+ ", unitstock=" + unitstock + "]";
	}
	
}
