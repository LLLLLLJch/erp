package com.menglang.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.pojo.Product;
import com.menglang.ssh.service.IProductService;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

	@Autowired
	private IProductService productService;

	public String list() {
		productService.findAll(pageBean);
		System.out.println("111"+pageBean);
		obj2Json(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize","products"});
		return NONE;
	}
	
	
	public String add() {
		
		return NONE;
	}
}
