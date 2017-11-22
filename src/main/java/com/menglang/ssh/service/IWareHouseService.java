package com.menglang.ssh.service;

import java.io.Serializable;

import com.menglang.ssh.pojo.WareHouse;
import com.menglang.ssh.vo.PageBean;

public interface IWareHouseService {

	void findAll(PageBean pageBean);

	Serializable add(WareHouse model);

	boolean delete(String ids);

	boolean update(WareHouse model);


}
