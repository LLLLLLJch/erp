package com.menglang.ssh.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class WareHouse {

	private Integer id;
	private String name;
	private String address;
	private String detail;
	private Date startTime;
	private Date endTime;
	private Set<Product> products = new HashSet<Product>();

	public WareHouse() {
		super();
	}

	public WareHouse(Integer id, String name, String address, String detail, Date startTime, Date endTime,
			Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.detail = detail;
		this.startTime = startTime;
		this.endTime = endTime;
		this.products = products;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", name=" + name + ", address=" + address + ", detail=" + detail + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

}
