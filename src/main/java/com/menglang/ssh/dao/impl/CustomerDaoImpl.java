package com.menglang.ssh.dao.impl;

import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.menglang.ssh.base.impl.BaseDaoImpl;
import com.menglang.ssh.dao.ICustomerDao;
import com.menglang.ssh.pojo.Customer;
import com.menglang.ssh.pojo.Order;
import com.mysql.jdbc.Connection;
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements ICustomerDao{

}
