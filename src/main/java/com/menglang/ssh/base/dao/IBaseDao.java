package com.menglang.ssh.base.dao;

import java.io.Serializable;
import java.util.List;

import com.menglang.ssh.vo.PageBean;

public interface IBaseDao<T> {

	/**
	 * 保存
	 * @param entity
	 */
	Serializable save(T entity);
	
	/**
	 * 修改
	 * @param enmity
	 * @return 
	 */
	boolean update(T enmity);
	
	/**
	 * 删除
	 * @param id
	 */
	boolean delete(T enmity);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	T findById(Serializable id);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	void findByPage(PageBean pageBean);
}
