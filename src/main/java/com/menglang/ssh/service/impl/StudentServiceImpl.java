package com.menglang.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IStudentDao;
import com.menglang.ssh.service.IStudentService;
import com.menglang.ssh.vo.PageBean;
@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public void find(PageBean pageBean) {
		studentDao.findByPage(pageBean);
	}

}
