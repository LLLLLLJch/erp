package com.menglang.ssh.pojo;

import java.util.Date;

public class OrderItem {

	private Integer id;
	private Integer customerId;
	private String orderNo;
	private String productId;
	private String productName;
	private String productImage;
	private Integer totalPrice;
	private Integer quantity;
	private Date createTime;
	private Date updateTime;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer customerId, String orderNo, String productId, String productName,
			String productImage, Integer totalPrice, Integer quantity, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderNo = orderNo;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.totalPrice = totalPrice;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
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
		return "OrderItem [id=" + id + ", customerId=" + customerId + ", orderNo=" + orderNo + ", productId="
				+ productId + ", productName=" + productName + ", productImage=" + productImage + ", totalPrice="
				+ totalPrice + ", quantity=" + quantity + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}

}
