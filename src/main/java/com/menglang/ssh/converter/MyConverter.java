package com.menglang.ssh.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyConverter extends StrutsTypeConverter{

	// 新需求： 要求项目中要支持的格式,如: yyyy-MM-dd/yyyyMMdd/yyyy年MM月dd日..

	// 先定义项目中支持的转换的格式
	DateFormat[] dateFormats = { new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("yyyy年MM月dd日") };
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// 判断: 内容不能为空
		if (values == null || values.length == 0) {
			return null;
		}
		// 判断类型必须为Date
		if (Date.class != toClass) {
			return null;
		}
		
		// 迭代：转换失败继续下一个格式的转换； 转换成功就直接返回
		for (int i=0; i<dateFormats.length; i++) {
			try {
				return dateFormats[i].parse(values[0]);
			} catch (ParseException e) {
				continue;
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

}
