package com.menglang.ssh.service;

import java.io.Serializable;
import java.util.List;

import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.pojo.Order;
import com.menglang.ssh.vo.PageBean;

public interface ICustomerService {

	void findAll(PageBean pageBean);

	Serializable add(Customer model);

	boolean update(Customer model);

	boolean delete(String ids);

}
