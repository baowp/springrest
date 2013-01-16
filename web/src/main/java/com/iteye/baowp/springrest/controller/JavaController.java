package com.iteye.baowp.springrest.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@RequestMapping("/sample")
public class JavaController extends BaseController {

	@RequestMapping(value = "/java")
	public String action() {
		String message = "java";
		deposit("message", message);
		deposit(message, "message");
		deposit("n", 2);
		return "groovy/list";
	}

	@RequestMapping(value = "/java/async")
	public String action2() {
		String message = "java";
		deposit("message", message);
		deposit(message, "message");
		deposit("n", 1);
		AsyncContext ctx = getRequest().startAsync();
		new Thread(new Executor(ctx)).start();
		return "groovy/list";
	}

	@RequestMapping(value = "/java/use{user}")
	public String action11(@PathVariable Integer user) {
		log.info(user);
		deposit("message", "java");
		return "groovy/list";
	}

}

class Executor implements Runnable {
	private AsyncContext ctx = null;

	public Executor(AsyncContext ctx) {
		this.ctx = ctx;
	}

	public void run() {
		try {
			// 等待5秒钟，以模拟业务方法的执行
			Thread.sleep(5000);
			PrintWriter out = ctx.getResponse().getWriter();
			ctx.getRequest().setAttribute("n", 3);
			out.println("业务处理完毕的时间：" + new Date() + ".<br>");
			out.flush();
			ctx.complete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
