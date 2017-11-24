package com.menglang.ssh.controller;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.common.SeverResponse;
import com.menglang.ssh.pojo.CustomerLinkMan;
import com.menglang.ssh.pojo.Staff;
import com.menglang.ssh.service.ICustomerLinkManService;

@Controller
@Scope("prototype")
public class CustomerLinkManAction extends BaseAction<CustomerLinkMan> {

	@Autowired
	private ICustomerLinkManService customerLinkManService;

	private String ids;
	
	public String list() {
		customerLinkManService.findAll(pageBean);
		obj2JsonForEasyUI(pageBean);
		System.out.println("----------");
		System.out.println(pageBean);
		return NONE;
	}
	
	public String add() {
		System.out.println(model);
		Serializable result = customerLinkManService.add(model);
		if(result != null){
			SeverResponse severResponse = SeverResponse.createSuccess("添加成功");
			obj2Json(severResponse);
		}else {
			SeverResponse severResponse = SeverResponse.createError("添加失败");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
	public String delete() {
		SeverResponse severResponse = null;
		if(customerLinkManService.delete(ids)){
			severResponse = SeverResponse.createSuccess("删除成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("删除失败");
			obj2Json(severResponse);
		}
		return NONE;
	}

	public String update() {
		System.out.println(model);
		SeverResponse severResponse = null;
		if(customerLinkManService.update(model)){
			severResponse = SeverResponse.createSuccess("修改成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("修改失败");
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
	
	public String findLinkMan() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomerLinkMan.class);
		detachedCriteria.add(Restrictions.eq("position","秘书"));
		List<CustomerLinkMan> list = customerLinkManService.findLinkMan(detachedCriteria);
		list2Json(list);
		return NONE;
	}
}
