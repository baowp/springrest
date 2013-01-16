package com.iteye.baowp.springrest.interceptor;

import java.lang.reflect.Method

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import net.sf.json.JSONSerializer

import org.springframework.core.annotation.AnnotationUtils
import org.springframework.ui.ExtendedModelMap
import org.springframework.validation.support.BindingAwareModelMap
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.support.HandlerMethodInvoker
import org.springframework.web.bind.annotation.support.HandlerMethodResolver
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.ServletHandlerMethodInvoker

import com.iteye.baowp.springrest.controller.BaseController;

public class JsonpGroovyInterceptor extends HandlerInterceptorAdapter {
	final static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(this
	.getClass());

	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof BaseController) {
			BaseController contro = ((BaseController) handler);
			String callback = contro.getCallback();
			if (callback != null && callback.length() > 20) {
				WebApplicationContext context = (WebApplicationContext) request
						.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				AnnotationMethodHandlerAdapter ha = context
						.getBean(AnnotationMethodHandlerAdapter.class);
				HandlerMethodResolver methodResolver = ha.getMethodResolver(handler);
				Method handlerMethod = methodResolver.resolveHandlerMethod(request);
				if(AnnotationUtils.findAnnotation(handlerMethod, ResponseBody.class) != null){
					HandlerMethodInvoker methodInvoker = new HandlerMethodInvoker(methodResolver);
					ServletWebRequest webRequest = new ServletWebRequest(request, response);
					ExtendedModelMap implicitModel = new BindingAwareModelMap();

					Object result = methodInvoker.invokeHandlerMethod(handlerMethod, handler, webRequest, implicitModel);
					//System.out.println( JSONSerializer.toJSON(result));
					response.setContentType("text/javascript;charset=utf-8");
					StringBuilder sb=new StringBuilder(callback);
					sb.append("(").append(JSONSerializer.toJSON(result)).append(")");
					response.getWriter().print(sb);
					return false;
				}
			}
		}

		return true;
	}
}
