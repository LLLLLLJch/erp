package com.menglang.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.ICustomerDao;
import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.pojo.Order;
import com.menglang.ssh.service.ICustomerService;
import com.menglang.ssh.vo.PageBean;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public void findAll(PageBean pageBean) {
		customerDao.findByPage(pageBean);
	}

	@Override
	public Serializable add(Customer model) {
		return customerDao.save(model);
	}

	@Override
	public boolean update(Customer model) {
		return customerDao.update(model);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(id));
			return customerDao.delete(customer);
		}
		return false;
	}

}
