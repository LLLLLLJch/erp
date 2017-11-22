package com.menglang.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.common.SeverResponse;
import com.menglang.ssh.pojo.Order;
import com.menglang.ssh.service.IOrderService;

@Controller
@Scope("prototype")
public class OrderAction extends BaseAction<Order> {

	@Autowired
	private IOrderService orderService;
	private String ids;

	public String list() {
		orderService.findAll(pageBean);
		obj2JsonForEasyUI(pageBean);
		return NONE;
	}

	public String delete() {
		SeverResponse severResponse = null;
		if(orderService.delete(ids)){
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
