package com.menglang.ssh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menglang.ssh.dao.IDataDicDao;
import com.menglang.ssh.pojo.DataDic;
import com.menglang.ssh.service.IDataDicService;
import com.menglang.ssh.vo.PageBean;

@Service
public class DataDicServiceImpl implements IDataDicService{

	@Autowired
	private IDataDicDao dataDicDao;
	
	@Override
	public void findAll(PageBean pageBean) {
		dataDicDao.findByPage(pageBean);
	}

	@Override
	public Serializable add(DataDic model) {
		return dataDicDao.save(model);
	}

	@Override
	public boolean update(DataDic model) {
		return dataDicDao.update(model);
	}

	@Override
	public boolean delete(String ids) {
		String[] array = ids.split(",");
		for (String id : array) {
			DataDic dataDic = new DataDic();
			dataDic.setId(Integer.parseInt(id));
			return dataDicDao.delete(dataDic);
		}
		return false;
	}
}
