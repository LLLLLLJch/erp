package com.menglang.ssh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Product {

	private Integer id;
	private String name;
	private String image;
	private Integer price;
	private Integer stock;
	private Integer status;
	private WareHouse wareHouse;
	public Product() {
		super();
	}
	public Product(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public WareHouse getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", stock=" + stock
				+ ", status=" + status + ", wareHouse=" + wareHouse + "]";
	}

}
