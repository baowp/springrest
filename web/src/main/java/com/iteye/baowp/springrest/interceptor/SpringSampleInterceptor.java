package com.iteye.baowp.springrest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SpringSampleInterceptor extends HandlerInterceptorAdapter {
	final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this
			.getClass());

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.info("sample interceptor preHandle");
		ServletRequestDataBinder binder = new ServletRequestDataBinder(handler);
		binder.bind(request);
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("sample interceptor postHandle");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("sample interceptor afterCompletion");
	}
}
