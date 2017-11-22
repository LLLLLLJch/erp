package com.menglang.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IOrderDao;
import com.menglang.ssh.pojo.Order;
import com.menglang.ssh.service.IOrderService;
import com.menglang.ssh.vo.PageBean;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderDao orderDao;

	@Override
	public void findAll(PageBean pageBean) {
		orderDao.findByPage(pageBean);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			Order order = new Order();
			order.setId(Integer.parseInt(id));
			return orderDao.delete(order);
		}
		return false;
	}
	
}
