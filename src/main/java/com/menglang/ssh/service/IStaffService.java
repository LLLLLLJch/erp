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

	List<Staff> findStaff(DetachedCriteria detachedCriteria);

}
