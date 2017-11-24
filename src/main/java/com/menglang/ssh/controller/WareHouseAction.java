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
import com.menglang.ssh.pojo.WareHouse;
import com.menglang.ssh.service.IWareHouseService;

@Controller
@Scope("prototype")
public class WareHouseAction extends BaseAction<WareHouse> {

	@Autowired
	private IWareHouseService wareHouseService;

	private String ids;
	public String list() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(WareHouse.class);
		if(model.getName() != null && !model.getName().equals("")){
			detachedCriteria.add(Restrictions.like("name","%"+model.getName()+"%"));
			pageBean.setDetachedCriteria(detachedCriteria);
		}
		wareHouseService.findAll(pageBean);
		System.out.println(pageBean);
		/*obj2JsonForEasyUI(pageBean);*/
		obj2Json(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize","products"});
		return NONE;
	}
	
	public String add() {
		Serializable result = wareHouseService.add(model);
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
		if(wareHouseService.delete(ids)){
			severResponse = SeverResponse.createSuccess("删除成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("删除失败");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
	public String update() {
		System.out.println("WareHouseAction.update()");
		System.out.println(model);
		SeverResponse severResponse = null;
		if(wareHouseService.update(model)){
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

	public String findWareHouse() {
		List<WareHouse> list = wareHouseService.findWareHouse();
		System.out.println(list);
		list2Json(list);
		return NONE;
	}
}
