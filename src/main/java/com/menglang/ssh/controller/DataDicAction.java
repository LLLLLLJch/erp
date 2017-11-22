package com.menglang.ssh.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.common.SeverResponse;
import com.menglang.ssh.pojo.DataDic;
import com.menglang.ssh.service.IDataDicService;

@Controller
@Scope("prototype")
public class DataDicAction extends BaseAction<DataDic> {

	@Autowired
	private IDataDicService dataDicService;
	private String ids;

	public String list() {
		dataDicService.findAll(pageBean);
		obj2JsonForEasyUI(pageBean);
		return NONE;
	}

	public String add() {
		System.out.println(model);
		Serializable result = dataDicService.add(model);
		SeverResponse severResponse = null;
		if (result != null) {
			severResponse = SeverResponse.createSuccess("添加成功");
			obj2Json(severResponse);
		} else {
			severResponse = SeverResponse.createError("添加失败");
			obj2Json(severResponse);
		}
		return NONE;
	}

	public String update() {
		SeverResponse severResponse = null;
		if (dataDicService.update(model)) {
			severResponse = SeverResponse.createSuccess("修改成功");
			obj2Json(severResponse);
		} else {
			severResponse = SeverResponse.createError("修改失败");
			obj2Json(severResponse);
		}
		return NONE;
	}

	public String delete() {
		SeverResponse severResponse = null;
		if (dataDicService.delete(ids)) {
			severResponse = SeverResponse.createSuccess("修改成功");
			obj2Json(severResponse);
		} else {
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

}
