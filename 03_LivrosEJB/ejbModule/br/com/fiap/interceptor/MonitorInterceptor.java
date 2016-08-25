package br.com.fiap.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MonitorInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		Object obj = context.proceed();
		
		System.out.println(System.currentTimeMillis());

		return obj;
	}
}