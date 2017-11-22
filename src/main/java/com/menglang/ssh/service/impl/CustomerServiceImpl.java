package com.menglang.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.ICustomerDao;
import com.menglang.ssh.pojo.Customer;
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


}
