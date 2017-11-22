package com.menglang.ssh.controller;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.common.SeverResponse;
import com.menglang.ssh.pojo.OrderItem;
import com.menglang.ssh.service.IOrderItemService;

@Controller
@Scope("prototype")
public class OrderItemAction extends BaseAction<OrderItem> {

	@Autowired
	private IOrderItemService orderItemService;
	private String ids;
	public String list() {
		System.out.println(model.getOrderNo()+"222222222");
		String orderNo = model.getOrderNo();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OrderItem.class);
		if(orderNo != null && !orderNo.equals("")){
			detachedCriteria.add(Restrictions.eq("orderNo", orderNo));
			pageBean.setDetachedCriteria(detachedCriteria);
		}
		orderItemService.findAll(pageBean);
		System.out.println(pageBean);
		obj2JsonForEasyUI(pageBean);
		return NONE;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String delete() {
		SeverResponse severResponse = null;
		if(orderItemService.delete(ids)){
			severResponse = SeverResponse.createSuccess("删除成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("删除失败");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
}
