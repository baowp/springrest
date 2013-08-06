package com.iteye.baowp.springrest.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iteye.baowp.springrest.service.CommService;

@Component
@Aspect
public class SampleAspect {
	@Autowired
	CommService commService;

	// @Before("execution(* com.iteye.baowp.springrest.controller..*.*(..))")
	@Before("execution(* com.iteye.baowp.springrest.controller.JavaController.*(..))")
	public void sample() {
		System.out.println("sample aspect");
		commService.print();
	}

	// @Before("execution(* com.iteye.baowp.springrest.controller..*.*(..))")
	@Before("execution(* com.iteye.baowp.springrest.service.impl.CityServiceImpl.*(..))")
	public void sample2() {
		System.out.println("sample server aspect");
		commService.print();
	}
}
