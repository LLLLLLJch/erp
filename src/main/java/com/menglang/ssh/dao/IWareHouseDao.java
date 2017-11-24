package com.menglang.ssh.dao;

import java.util.List;

import com.menglang.ssh.base.dao.IBaseDao;
import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.pojo.WareHouse;

public interface IWareHouseDao extends IBaseDao<WareHouse>{

	List<WareHouse> findWareHouse();


}
