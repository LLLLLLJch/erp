package com.menglang.ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.menglang.ssh.base.dao.IBaseDao;
import com.menglang.ssh.pojo.CustomerLinkMan;
public interface ICustomerLinkManDao extends IBaseDao<CustomerLinkMan>{

	List<CustomerLinkMan> findLinkMan(DetachedCriteria detachedCriteria);

}
