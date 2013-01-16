package com.iteye.baowp.springrest.util;

import java.util.HashMap;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Spel extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	private static Spel spel = new Spel();

	public static Spel getSpel() {
		return spel;
	}

	private Spel() {
	}

	public Object get(Object key) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression((String) key);
		Object message = exp.getValue();
		return message;
	}
}
