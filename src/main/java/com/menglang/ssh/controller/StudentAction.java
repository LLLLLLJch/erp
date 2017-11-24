package com.menglang.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.menglang.ssh.base.controller.BaseAction;
import com.menglang.ssh.pojo.Student;
import com.menglang.ssh.service.IStudentService;
@Controller
@Scope("prototype")
public class StudentAction extends BaseAction<Student>{

	@Autowired
	private IStudentService studentService;
	public String list() {
		studentService.find(pageBean);
		System.out.println(pageBean);
		obj2Json(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize","students"});
		//list2Json(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize","students"});
		return NONE;
	}
}
