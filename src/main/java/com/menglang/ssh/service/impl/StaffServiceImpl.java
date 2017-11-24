package com.menglang.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IStaffDao;
import com.menglang.ssh.pojo.Staff;
import com.menglang.ssh.service.IStaffService;
import com.menglang.ssh.vo.PageBean;
@Service
public class StaffServiceImpl implements IStaffService{

	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public void findAll(PageBean pageBean) {
		staffDao.findByPage(pageBean);
	}

	@Override
	public Serializable add(Staff model) {
		return staffDao.save(model);
	}

	@Override
	public boolean check(Integer num) {
		if(staffDao.check(num)){
			return true;
		}
		return false;
	}

	@Override
	public void findStaff(PageBean pageBean) {
		staffDao.findByPage(pageBean);
	}

	@Override
	public List<Staff> find(DetachedCriteria detachedCriteria) {
		return staffDao.findStaff(detachedCriteria);
	}

	@Override
	public Staff checkLogin(Staff model) {
		return staffDao.checkLogin(model);
	}

	@Override
	public Staff checkName(String staffName) {
		return staffDao.checkName(staffName);
	}

	@Override
	public boolean updatePassword(Staff model) {
		return staffDao.update(model);
	}

	@Override
	public boolean update(Staff model) {
		return staffDao.update(model);
	}

}
