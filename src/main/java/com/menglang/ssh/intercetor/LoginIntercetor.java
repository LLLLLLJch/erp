package com.menglang.ssh.intercetor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginIntercetor implements Interceptor{

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		ActionProxy proxy = invocation.getProxy();
		String methodName = proxy.getMethod();
		System.out.println("----------"+methodName);
		if(!"login".equals(methodName) || "execute".equals(methodName)){
			Object object = ac.getSession().get("staff");
			if(object==null){
				return "login";
			}
		}
		return invocation.invoke();
	}

}
