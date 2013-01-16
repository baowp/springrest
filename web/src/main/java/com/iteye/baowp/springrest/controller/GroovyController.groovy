package com.iteye.baowp.springrest.controller

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/sample")
class GroovyController extends BaseController {

	@RequestMapping(value = "/groovy")
	public String action() {
		deposit("message", "groovy");
		return "groovy/list";
	}

	@RequestMapping(value = "/groovy/{name}")
	String action2(@PathVariable name){
		deposit "message", name
		return "groovy/list"
	}
}
