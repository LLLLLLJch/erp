package com.menglang.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IOrderItemDao;
import com.menglang.ssh.pojo.OrderItem;
import com.menglang.ssh.service.IOrderItemService;
import com.menglang.ssh.vo.PageBean;
@Service
public class OrderItemServiceImpl implements IOrderItemService{

	@Autowired
	private IOrderItemDao orderItemDao;

	@Override
	public void findAll(PageBean pageBean) {
		orderItemDao.findByPage(pageBean);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			OrderItem orderItem = new OrderItem();
			orderItem.setId(Integer.parseInt(id));
			return orderItemDao.delete(orderItem);
		}
		return false;
	}
}
