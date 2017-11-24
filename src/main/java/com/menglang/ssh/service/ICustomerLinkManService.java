package com.menglang.ssh.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.menglang.ssh.pojo.CustomerLinkMan;
import com.menglang.ssh.vo.PageBean;

public interface ICustomerLinkManService {

	void findAll(PageBean pageBean);

	Serializable add(CustomerLinkMan model);

	boolean delete(String ids);

	boolean update(CustomerLinkMan model);

	List<CustomerLinkMan> findLinkMan(DetachedCriteria detachedCriteria);

}
