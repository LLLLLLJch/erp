package com.menglang.ssh.service;

import java.io.Serializable;

import com.menglang.ssh.pojo.DataDic;
import com.menglang.ssh.vo.PageBean;

public interface IDataDicService {

	void findAll(PageBean pageBean);

	Serializable add(DataDic model);

	boolean update(DataDic model);

	boolean delete(String ids);

}
