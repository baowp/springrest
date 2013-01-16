package com.iteye.baowp.springrest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONSerializer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iteye.baowp.springrest.pojo.Apple;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@RequestMapping("/topic")
public class TopicController extends BaseController {
	private Log log = LogFactory.getLog(getClass());
	public String name;
	private String username;
	private String id;
	private Apple apple;

	@RequestMapping(value = "/{id}")
	public String helloWorld(@PathVariable String id,
			@ModelAttribute("fruit") @Valid Apple fruit, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> map) {
		request.setAttribute("message", "You Input Topci Id is: <b>" + id
				+ "</b>");
		result.rejectValue("price2", null, "defined");
		List<FieldError> errorList = result.getFieldErrors();
		for (FieldError error : errorList) {
			if (error.getField().equals("price"))
				// errorList.remove(0);
				log.info(error);
		}
		Apple apple=new Apple();
		apple.setName("apple");
		deposit("fruit", apple);
//		map.put("fruit", apple);
		return "topic";
	}

	@RequestMapping(value = "/add")
	public String test(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> map) {
		System.out.println("Hello www.JavaBloger.com ");
		request.setAttribute("message",
				"Hello JavaBloger ! ,@RequestMapping(value='/add')");
		map.put("command", this);
		return "topic";

	}

	@RequestMapping(value = "/apple")
	@ResponseBody
	public Apple apple(Apple apple) {
		log.info(apple);
		log.info(JSONSerializer.toJSON(apple));
		return apple;
	}

	@RequestMapping(value = "/apple2")
	@ResponseBody
	public void apple2(Apple apple, String callback) {
		log.info(apple);
		log.info(callback);
		List<Apple> list = new ArrayList<Apple>();
		list.add(apple);
		list.add(apple);
		try {
			getResponse().getWriter().println(
					callback + "(" + JSONSerializer.toJSON(apple) + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

}
