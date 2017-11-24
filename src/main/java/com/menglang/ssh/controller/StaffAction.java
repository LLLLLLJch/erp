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
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

	@Autowired
	private IStaffService staffService;
	
	private String newPassword;
	
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
		List<Staff> list = staffService.find(detachedCriteria);
		list2Json(list);
		return NONE;
	}
	
	public String login(){
		System.out.println(model);
		Staff staff = staffService.checkLogin(model);
		if(staff == null){
			return "login";
		}
		ActionContext.getContext().getSession().put("staff", staff);
		return SUCCESS;
	}
	
	public String checkName() {
		SeverResponse severResponse = null;
		Staff staff =  staffService.checkName(model.getStaffName());
		System.out.println(staff);
		if(staff != null){
			severResponse = SeverResponse.createSuccess("用户名正确");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("用户名不存在");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
	public String updatePassword() {
		System.out.println(model);
		System.out.println(newPassword);
		SeverResponse severResponse = null;
		Staff staff = staffService.checkName(model.getStaffName());
		staff.setPassword(newPassword);
		System.out.println(model);
		if(staffService.updatePassword(staff)){
			severResponse = SeverResponse.createSuccess("修改成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("修改失败");
			obj2Json(severResponse);
		}
		return NONE;
	}

	public String update() {
		SeverResponse severResponse = null;
		if(staffService.update(model)){
			severResponse = SeverResponse.createSuccess("修改成功");
			obj2Json(severResponse);
		}else {
			severResponse = SeverResponse.createError("修改失败");
			obj2Json(severResponse);
		}
		return NONE;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
