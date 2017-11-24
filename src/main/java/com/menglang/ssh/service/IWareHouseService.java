package com.menglang.ssh.service;

import java.io.Serializable;
import java.util.List;

import com.menglang.ssh.pojo.WareHouse;
import com.menglang.ssh.vo.PageBean;

public interface IWareHouseService {

	void findAll(PageBean pageBean);

	Serializable add(WareHouse model);

	boolean delete(String ids);

	boolean update(WareHouse model);

	List<WareHouse> findWareHouse();


}
