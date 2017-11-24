package com.menglang.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.menglang.ssh.base.impl.BaseDaoImpl;
import com.menglang.ssh.dao.IStaffDao;
import com.menglang.ssh.pojo.Staff;
import com.opensymphony.xwork2.mock.MockObjectTypeDeterminer;
@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements IStaffDao{

	@Override
	public boolean check(Integer num) {
		String sql = "FROM Staff WHERE num = ?";
		List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
		if(list != null){
			return true;
		}
		return false;
	}

	@Override
	public List<Staff> findStaff(DetachedCriteria detachedCriteria) {
		List<Staff> findByCriteria = (List<Staff>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return findByCriteria;
	}

	@Override
	public Staff checkLogin(Staff model) {
		String sql = "FROM Staff where staffName=? AND password=? AND role=?";
		List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,model.getStaffName(),model.getPassword(),model.getRole());
		Staff staff = list.get(0); 
		return staff;
	}

	@Override
	public Staff checkName(String staffName) {
		String sql = "FROM Staff WHERE staffName=?";
		List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, staffName);
		Staff staff = list.get(0);
		return staff;
	}
}
