package com.iteye.baowp.springrest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iteye.baowp.springrest.pojo.Apple;
import com.iteye.baowp.springrest.pojo.Users;

@SuppressWarnings("serial")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@RequestMapping(value = "/login")
	public String test2(HttpServletRequest request,
			HttpServletResponse response, Users userinfo, Apple apple) {
		if (userinfo.getUsername().equals("username")
				&& userinfo.getPassword().equals("password")) {
			request.setAttribute("user", userinfo);
			return "users/list";
		} else {
			return "users/loginerr";
		}

	}

}
