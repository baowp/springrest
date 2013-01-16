package com.iteye.baowp.springrest.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@RequestMapping("/sample2")
public class CopyOfJavaController extends JavaController {

	@RequestMapping(value = "/java")
	public String action2() {
		deposit("message", "java");
		return "groovy/list";
	}

	@RequestMapping(value = "/java/{user}")
	public String action21(@PathVariable String user) {
		log.info(user);
		deposit("message", "java2");
		return "groovy/list";
	}
}
