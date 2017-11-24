package com.menglang.ssh.controller;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.common.SeverResponse;
import com.menglang.ssh.pojo.Product;
import com.menglang.ssh.service.IProductService;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

	@Autowired
	private IProductService productService;

	private String ids;
	
	public String list() {
		productService.findAll(pageBean);
		System.out.println("111"+pageBean);
		obj2Json(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize","products"});
		return NONE;
	}
	
	public String add() {
		System.out.println(model);
		SeverResponse severResponse = null;
		Serializable result = productService.add(model);
		if(result != null){
			severResponse = SeverResponse.createSuccess("添加成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("添加失败");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
	public String update() {
		SeverResponse severResponse = null;
		if(productService.update(model)){
			severResponse = SeverResponse.createSuccess("修改成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("修改失败");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
	public String delete() {
		SeverResponse severResponse = null;
		if(productService.delete(ids)){
			severResponse = SeverResponse.createSuccess("删除成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("删除失败");
			obj2Json(severResponse);
		}
		return NONE;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
