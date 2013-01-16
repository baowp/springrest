package com.iteye.baowp.springrest.interceptor

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import com.iteye.baowp.springrest.controller.BaseController

class RequestResponseInterceptor extends HandlerInterceptorAdapter {

	boolean preHandle(HttpServletRequest  request,
	HttpServletResponse response, handler) throws Exception {
		if(handler instanceof BaseController){
			handler.setRequest(request);
			handler.setResponse(response);
		}
		return true;
	}

	void afterCompletion(HttpServletRequest request,HttpServletResponse response,  handler,Exception ex)
	throws Exception {
	}
}
