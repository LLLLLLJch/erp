package com.menglang.ssh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IProductDao;
import com.menglang.ssh.pojo.Product;
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

	@Override
	public Serializable add(Product model) {
		return productDao.save(model);
	}

	@Override
	public boolean update(Product model) {
		return productDao.update(model);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			Product product = new Product();
			product.setId(Integer.parseInt(id));
			return productDao.delete(product);
		}
		return false;
	}
}
