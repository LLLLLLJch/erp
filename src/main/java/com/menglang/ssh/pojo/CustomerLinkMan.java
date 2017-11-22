package com.menglang.ssh.pojo;

public class CustomerLinkMan {

	private Integer id;
	private Integer customerId;
	private String linkName;
	private String gender;
	private String position;
	private Integer phone;

	public CustomerLinkMan() {
		super();
	}

	public CustomerLinkMan(Integer id, Integer customerId, String linkName, String gender, String position,
			Integer phone) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.linkName = linkName;
		this.gender = gender;
		this.position = position;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerLinkMan [id=" + id + ", customerId=" + customerId + ", linkName=" + linkName + ", gender="
				+ gender + ", position=" + position + ", phone=" + phone + "]";
	}

}
