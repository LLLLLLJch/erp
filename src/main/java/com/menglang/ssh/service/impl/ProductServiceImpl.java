package com.menglang.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IProductDao;
import com.menglang.ssh.service.IProductService;
import com.menglang.ssh.vo.PageBean;
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;

	@Override
	public void findAll(PageBean pageBean) {
		productDao.findByPage(pageBean);
	}
}
