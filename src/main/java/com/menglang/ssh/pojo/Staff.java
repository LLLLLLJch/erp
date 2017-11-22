package com.menglang.ssh.pojo;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder.In;

public class Staff {

	private Integer id;
	private Integer num;
	private String staffName;
	private String password;
	private String role;
	private String name;
	private Integer phone;
	private Date createTime;

	public Staff() {
		super();
	}

	public Staff(Integer id, Integer num, String staffName, String password, String role, String name, Integer phone,
			Date createTime) {
		super();
		this.id = id;
		this.num = num;
		this.staffName = staffName;
		this.password = password;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.createTime = createTime;
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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", num=" + num + ", staffName=" + staffName + ", password=" + password + ", role="
				+ role + ", name=" + name + ", phone=" + phone + ", createTime=" + createTime + "]";
	}

}
