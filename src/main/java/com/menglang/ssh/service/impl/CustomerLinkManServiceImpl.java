package com.menglang.ssh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.ICustomerLinkManDao;
import com.menglang.ssh.pojo.CustomerLinkMan;
import com.menglang.ssh.service.ICustomerLinkManService;
import com.menglang.ssh.vo.PageBean;

@Service
public class CustomerLinkManServiceImpl implements ICustomerLinkManService{

	@Autowired
	private ICustomerLinkManDao customerLinkManDao;
	
	@Override
	public void findAll(PageBean pageBean) {
		customerLinkManDao.findByPage(pageBean);
	}

	@Override
	public Serializable add(CustomerLinkMan model) {
		return customerLinkManDao.save(model);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			CustomerLinkMan customerLinkMan = new CustomerLinkMan();
			customerLinkMan.setId(Integer.parseInt(id));
			return customerLinkManDao.delete(customerLinkMan);
		}
		return false;
	}

	@Override
	public boolean update(CustomerLinkMan model) {
		return customerLinkManDao.update(model);
	}


}
