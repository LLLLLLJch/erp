package com.menglang.ssh.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.menglang.ssh.pojo.Banji;
import com.menglang.ssh.pojo.Product;
import com.menglang.ssh.pojo.Student;
import com.menglang.ssh.pojo.WareHouse;
import com.menglang.ssh.vo.PageBean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JsonLibTest {

	@Test
	public void test1() {
		Student student = new Student();
		Student student1 = new Student();
		student.setId(111);
		student.setName("aaa");
		Banji banji = new Banji();
		banji.setId(999);
		banji.setName("gao");
		banji.getStudents().add(student1);
		banji.getStudents().add(student);
		student.setBanji(banji);

		System.out.println(student);
		JsonConfig jsonConfig = new JsonConfig();
		//jsonConfig.setExcludes(new String[]{"students"});
		//jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		// 指定哪些属性不进行json转换
		String json = JSONObject.fromObject(student, jsonConfig).toString();
		System.out.println(json);

	}
	
	/*@Test
	public void tewst1() {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPageSize(3);
		pageBean.setTotal(3);
		List<Product> list = new ArrayList<Product>();
		Product product1 = new Product("p1");
		Product product2 = new Product("p2");
		WareHouse wareHouse = new WareHouse();
		wareHouse.getProducts().add(product1);
		wareHouse.getProducts().add(product2);
		list.add(product2);
		list.add(product1);
		pageBean.setRows(list);
		//wareHouse.setProducts(null);
		product1.setWareHouse(wareHouse);
		product2.setWareHouse(wareHouse);
		System.out.println(pageBean);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"products"});
		//jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		// 指定哪些属性不进行json转换
		String json = JSONObject.fromObject(product1, jsonConfig).toString();
		System.out.println(json);

	}*/
	
}
