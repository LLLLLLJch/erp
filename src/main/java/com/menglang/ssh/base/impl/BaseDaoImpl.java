package com.menglang.ssh.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.menglang.ssh.base.dao.IBaseDao;
import com.menglang.ssh.pojo.Product;
import com.menglang.ssh.pojo.WareHouse;
import com.menglang.ssh.vo.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	// 代表当前操作的实体类的类型 Student.class Admin.class
	private Class<T> entityClass;

	// 注入Spring容器中的会话工厂。
	// 注解可以用在属性也可以用在方法.扫描到方法会调用，方法的参数会从容器中找
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public BaseDaoImpl() {
		// this:当前运行的类(AdminDao/StudentDao)
		// this.getClass:当前运行类的字节码:AdminDao.class/StudentDao.class
		// this.getClass().getGenericSuperclass():当前运行类的父类即为：BaseDaoImpl<Admin>
		Type type = this.getClass().getGenericSuperclass();
		// 强制转化为参数化类型BaseDaoImpl<Admin.clsss>
		ParameterizedType superClass = (ParameterizedType) type;
		// BaseDaoImpl<Admin,Student>参数可以有多个
		Type[] actualTypeArguments = superClass.getActualTypeArguments();// [Admin.class]
		// 获取数组中第一个元素
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	@Override
	public Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	@Override
	public boolean delete(T entity) {
		try {
			getHibernateTemplate().delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(T entity) {
		try {
			getHibernateTemplate().update(entity);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public T findById(Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// "FROM student"
		String sql = "FROM " + entityClass.getSimpleName();
		return (List<T>) getHibernateTemplate().find(sql);
	}

	@Override
	public void findByPage(PageBean pageBean) {
		Integer currentPage = pageBean.getCurrentPage();
		Integer pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		
		//查询total:总记录数
		detachedCriteria.setProjection(Projections.rowCount());
		List<?> countList = getHibernateTemplate().findByCriteria(detachedCriteria);
		long total = (long) countList.get(0);
		pageBean.setTotal((int)total);
		
		//rows:当前页数据
		detachedCriteria.setProjection(null);
		int firstResult = (currentPage - 1) * pageSize;
		List<?> rows = getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, pageSize);
		pageBean.setRows(rows);
		System.out.println(pageBean);
	}

}
