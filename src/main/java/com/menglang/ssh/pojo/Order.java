package com.menglang.ssh.pojo;

import java.util.Date;

public class Order {

	private Integer id;
	private String orderNo;
	private Integer customerId;
	private Integer payment;
	private Integer quantity;
	private Date createTime;
	private Date updateTime;

	public Order() {
		super();
	}

	public Order(Integer id, String orderNo, Integer customerId, Integer payment, Integer quantity, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.payment = payment;
		this.quantity = quantity;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", customerId=" + customerId + ", payment=" + payment
				+ ", quantity=" + quantity + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
