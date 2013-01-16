package extend;

import org.junit.Test;

public class B extends A {

	protected Object o;

	@Test
	public void t() {
		log.info(o);
		log.info(super.o == o);
	}

	protected void m2() {
		log.info("b.m2");
	}
}
