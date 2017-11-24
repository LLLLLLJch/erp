package com.menglang.ssh.service;

import java.io.Serializable;

import com.menglang.ssh.pojo.Product;
import com.menglang.ssh.vo.PageBean;

public interface IProductService {

	void findAll(PageBean pageBean);

	Serializable add(Product model);

	boolean update(Product model);

	boolean delete(String ids);

}
