package com.menglang.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.menglang.ssh.base.impl.BaseDaoImpl;
import com.menglang.ssh.dao.ICustomerLinkManDao;
import com.menglang.ssh.pojo.CustomerLinkMan;
@Repository
public class CustomerLinkManDaoImpl extends BaseDaoImpl<CustomerLinkMan> implements ICustomerLinkManDao{

	@Override
	public List<CustomerLinkMan> findLinkMan(DetachedCriteria detachedCriteria) {
		List<CustomerLinkMan> findByCriteria = (List<CustomerLinkMan>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return findByCriteria;
	}

}
