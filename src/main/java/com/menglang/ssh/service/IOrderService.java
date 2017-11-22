package com.menglang.ssh.service;

import com.menglang.ssh.vo.PageBean;

public interface IOrderService {

	void findAll(PageBean pageBean);

	boolean delete(String ids);

}
