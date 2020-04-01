package com.zy.SimpleDemo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.zy.security.web.config.subject.FilterComparator;


/**
* @author zy
* @Date 2020-02-18 周二 下午 17:37:59
* @Description 过滤器添加方法测试
* @version 
* ---
*  初始化的过滤器链标识：
* 	com.zy.security.web.filter.CsrfFilter--10
	com.zy.security.web.filter.AbstractAuthenticationProcessingFilter--40
	com.zy.security.web.filter.SessionManagementFilter--80
	com.zy.security.web.filter.SecurityContextPersistenceFilter--10
	com.zy.security.web.filter.RememberMeAuthenticationFilter--60
	com.zy.security.web.filter.CsrfRequestMsgFilter--12
	com.zy.security.web.filter.LogoutFilter--30
	com.zy.security.web.filter.UsernamePasswordAuthenticationFilter--41
	com.zy.security.web.filter.DefaultLoginPageGeneratingFilter--50
	com.zy.security.web.filter.AnonymousAuthenticationFilter--70
	com.zy.security.web.filter.AccessManagementFilter--90
	com.zy.security.web.filter.CsrfCookieFilter--11	
*/
public class Test {
	public static void main(String[] args) {
		FilterComparator filterComparator = new FilterComparator();
		
//		filterComparator.registerBefore(FilterTest.class, AnonymousAuthenticationFilter.class);
//		filterComparator.registerAt(FilterTest.class, AnonymousAuthenticationFilter.class);
//		filterComparator.registerAfter(FilterTest.class, AnonymousAuthenticationFilter.class);
//		filterComparator.registerEnd(FilterTest.class);
//		filterComparator.registerEnd(SessionManagementFilter.class);
		
		Map<String, Integer> filterToOrder = filterComparator.getFilterToOrder();
		for (String string : filterToOrder.keySet()) {
			System.out.println(string+"--"+filterToOrder.get(string));
		}
	}
}
class FilterTest implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("自定义fiter-init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("自定义fiter-doFilter");
	}

	@Override
	public void destroy() {
		System.out.println("自定义fiter-destroy");
		
	}
}