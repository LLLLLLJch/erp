package com.menglang.ssh.vo;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean {

	private Integer currentPage;
	private Integer pageSize;
	private Integer total;
	private List<?> rows;
	private DetachedCriteria detachedCriteria;

	public PageBean() {
		super();
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", total=" + total + ", rows=" + rows
				+ ", detachedCriteria=" + detachedCriteria + "]";
	}

}
