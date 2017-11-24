package com.menglang.ssh.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.common.SeverResponse;
import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.pojo.Order;
import com.menglang.ssh.service.ICustomerService;

@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction<Customer> {

	@Autowired
	private ICustomerService customerService;
	private String ids;
	public String list() {
		customerService.findAll(pageBean);
		obj2JsonForEasyUI(pageBean);
		return NONE;
	}
	
	public String add() {
		SeverResponse severResponse = null;
		Serializable result = customerService.add(model);
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
		if(customerService.update(model)){
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
		if(customerService.delete(ids)){
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
