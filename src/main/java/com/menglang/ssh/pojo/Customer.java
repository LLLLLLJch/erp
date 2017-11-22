package com.menglang.ssh.pojo;

public class Customer {

	private Integer id;
	private Integer num;
	private String name;
	private Integer phone;
	private String address;
	private String staffName;
	private String linkManName;

	public Customer() {
		super();
	}

	public Customer(Integer id, Integer num, String name, Integer phone, String address, String staffName,
			String linkManName) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.staffName = staffName;
		this.linkManName = linkManName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getLinkManName() {
		return linkManName;
	}

	public void setLinkManName(String linkManName) {
		this.linkManName = linkManName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", num=" + num + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", staffName=" + staffName + ", linkManName=" + linkManName + "]";
	}

}
