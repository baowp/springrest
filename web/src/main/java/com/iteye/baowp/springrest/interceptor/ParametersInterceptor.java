package com.iteye.baowp.springrest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iteye.baowp.springrest.controller.BaseController;
import com.iteye.baowp.springrest.util.Spel;

public class ParametersInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof BaseController) {
			ServletRequestDataBinder binder = new ServletRequestDataBinder(
					handler);
			binder.bind(request);
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null)
			return;
		modelAndView.addObject(handler);
		modelAndView.addObject("command", handler);
		request.setAttribute("spel", Spel.getSpel());
	}
}
