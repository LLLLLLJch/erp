package com.menglang.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.ICustomerDao;
import com.menglang.ssh.dao.IWareHouseDao;
import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.pojo.WareHouse;
import com.menglang.ssh.service.ICustomerService;
import com.menglang.ssh.service.IWareHouseService;
import com.menglang.ssh.vo.PageBean;

@Service
public class WareHouseServiceImpl implements IWareHouseService{

	@Autowired
	private IWareHouseDao wareHouseDao;
	
	@Override
	public void findAll(PageBean pageBean) {
		wareHouseDao.findByPage(pageBean);
	}

	@Override
	public Serializable add(WareHouse model) {
		return wareHouseDao.save(model);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			WareHouse wareHouse = new WareHouse();
			wareHouse.setId(Integer.parseInt(id));
			return wareHouseDao.delete(wareHouse);
		}
		return false;
	}

	@Override
	public boolean update(WareHouse model) {
		return wareHouseDao.update(model);
	}


}
