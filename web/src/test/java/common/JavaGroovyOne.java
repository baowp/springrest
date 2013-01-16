package common;

import junit.OneTest;

import net.sf.json.JSONSerializer;

import org.junit.Test;

import com.iteye.baowp.springrest.pojo.Users;

public class JavaGroovyOne {
	@Test
	public void t() {
		System.out.println("java");
		OneTest one = new OneTest();
		one.aa();
		one.setI(1);
		System.out.println(one.getI());
	}

	public void t2() {
		Users us = new Users();
		us.setId(1234);
		us.setUsername("username");
		System.out.println(JSONSerializer.toJSON(us));
	}

}
