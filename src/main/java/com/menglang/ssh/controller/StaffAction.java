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
import com.menglang.ssh.pojo.Staff;
import com.menglang.ssh.service.IStaffService;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

	@Autowired
	private IStaffService staffService;

	public String list() {
		staffService.findAll(pageBean);
		obj2JsonForEasyUI(pageBean);
		return NONE;
	}
	
	public String add() {
		boolean success = staffService.check(model.getNum());
		if(success){
			SeverResponse severResponse = SeverResponse.createSuccess("工号已存在，请换其他工号");
			obj2Json(severResponse);
		}
		System.out.println(model);
		Integer num = 1212+model.getNum();
		model.setNum(num);
		Serializable result = staffService.add(model);
		if(result != null){
			SeverResponse severResponse = SeverResponse.createSuccess("添加成功");
			obj2Json(severResponse);
		}else {
			SeverResponse severResponse = SeverResponse.createError("添加失败");
			obj2Json(severResponse);
		}
		
		return NONE;
	}
	
	public String findStaff() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		detachedCriteria.add(Restrictions.eq("role","销售主管"));
		List<Staff> list = staffService.findStaff(detachedCriteria);
		obj2Json(list);
		return NONE;
	}
}
