package com.menglang.ssh.service;

import java.util.List;

import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.vo.PageBean;

public interface ICustomerService {

	void findAll(PageBean pageBean);

}
