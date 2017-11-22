package com.menglang.ssh.pojo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
public class WareHouse {

	private Integer id;
	private String name;
	private String address;
	private Set<Product> products = new HashSet<Product>();


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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
