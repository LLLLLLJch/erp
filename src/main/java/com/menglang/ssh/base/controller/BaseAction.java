package com.menglang.ssh.base.controller;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.menglang.ssh.common.DateJsonValueProcessor;
import com.menglang.ssh.vo.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected PageBean pageBean = new PageBean();

	//protect Student student;
	protected T model;
	//创建离线查询对象
	protected DetachedCriteria detachedCriteria = null;

	@Override
	public T getModel() {
		return model;
	}
	
	private int page;//第几页
	private int rows;//每页多少数据

	public BaseAction() {
		// this:当前运行的类(AdminDao/StudentDao)
		// this.getClass:当前运行类的字节码:AdminDao.class/StudentDao.class
		// this.getClass().getGenericSuperclass():当前运行类的父类即为：BaseDaoImpl<Admin>
		Type type = this.getClass().getGenericSuperclass();
		// 强制转化为参数化类型BaseDaoImpl<Admin.clsss>
		ParameterizedType superClass = (ParameterizedType) type;
		// BaseDaoImpl<Admin,Student>参数可以有多个
		Type[] actualTypeArguments = superClass.getActualTypeArguments();// [Admin.class]
		// 获取数组中第一个元素
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将任意对象转换成json返回给浏览器
	 * @param object
	 */
	public void obj2Json(Object object, String... excludes) {
		// 将pageBean转换成json
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		//指定哪些属性不进行json转换
		jsonConfig.setExcludes(excludes);
		String json = JSONObject.fromObject(object, jsonConfig).toString();
		System.out.println(json);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void obj2JsonForEasyUI(Object object) {
		obj2Json(object, new String[]{"currentPage", "detachedCriteria", "pageSize"});
	}

	public void list2Json(Object object, String... excludes) {
		// 将pageBean转换成json
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		//指定哪些属性不进行json转换
		jsonConfig.setExcludes(excludes);
		String json = JSONArray.fromObject(object, jsonConfig).toString();
		System.out.println(json);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		pageBean.setCurrentPage(page);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
		pageBean.setPageSize(rows);
	}
}
