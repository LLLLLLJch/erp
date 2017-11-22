package com.menglang.ssh.service;

import com.menglang.ssh.vo.PageBean;

public interface IOrderItemService {

	void findAll(PageBean pageBean);

	boolean delete(String ids);

}
