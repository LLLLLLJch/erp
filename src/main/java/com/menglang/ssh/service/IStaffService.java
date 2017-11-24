package com.menglang.ssh.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.menglang.ssh.pojo.Staff;
import com.menglang.ssh.vo.PageBean;

public interface IStaffService {

	void findAll(PageBean pageBean);

	Serializable add(Staff model);

	boolean check(Integer num);

	void findStaff(PageBean pageBean);

	List<Staff> find(DetachedCriteria detachedCriteria);

	Staff checkLogin(Staff model);

	Staff checkName(String staffName);

	boolean updatePassword(Staff model);

	boolean update(Staff model);

}
