package com.menglang.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.menglang.ssh.base.impl.BaseDaoImpl;
import com.menglang.ssh.dao.IProductDao;
import com.menglang.ssh.pojo.Product;
import com.menglang.ssh.vo.PageBean;
@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao{


}
