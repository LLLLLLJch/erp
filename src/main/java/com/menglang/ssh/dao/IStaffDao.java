package com.menglang.ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.menglang.ssh.base.dao.IBaseDao;
import com.menglang.ssh.pojo.Staff;

public interface IStaffDao extends IBaseDao<Staff>{

	boolean check(Integer num);

	List<Staff> findStaff(DetachedCriteria detachedCriteria);

}
