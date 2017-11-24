package com.menglang.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.menglang.ssh.base.impl.BaseDaoImpl;
import com.menglang.ssh.dao.IWareHouseDao;
import com.menglang.ssh.pojo.WareHouse;
@Repository
public class WareHouseDaoImpl extends BaseDaoImpl<WareHouse> implements IWareHouseDao{

	@Override
	public List<WareHouse> findWareHouse() {
		String sql = "FROM WareHouse";
		List<WareHouse> list = (List<WareHouse>) getHibernateTemplate().find(sql);
		return list;
	}


}
