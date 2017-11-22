package com.menglang.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.service.ICustomerService;

@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction<Customer> {

	@Autowired
	private ICustomerService customerService;

	public String list() {
		customerService.findAll(pageBean);
		obj2JsonForEasyUI(pageBean);
		return NONE;
	}
}
