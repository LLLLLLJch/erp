package com.menglang.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.menglang.ssh.base.impl.BaseDaoImpl;
import com.menglang.ssh.dao.IStaffDao;
import com.menglang.ssh.pojo.Staff;
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
		List<Staff> list = (List<Staff>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
