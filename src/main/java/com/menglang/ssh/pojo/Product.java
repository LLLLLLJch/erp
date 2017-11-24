package com.menglang.ssh.pojo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Product {

	private Integer id;
	private String name;
	private String image;
	private Integer price;
	private Integer stock;
	private Integer status;
	private Set<WareHouse> wareHouses = new HashSet<WareHouse>();

	public Product() {
		super();
	}

	public Product(Integer id, String name, String image, Integer price, Integer stock, Integer status,
			Set<WareHouse> wareHouses) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.wareHouses = wareHouses;
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

	public Set<WareHouse> getWareHouses() {
		return wareHouses;
	}

	public void setWareHouses(Set<WareHouse> wareHouses) {
		this.wareHouses = wareHouses;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", stock=" + stock
				+ ", status=" + status + ", wareHouses=" + wareHouses + "]";
	}

}
