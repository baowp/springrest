package extend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.iteye.baowp.springrest.pojo.Apple;

public class A {
	protected Log log = LogFactory.getLog(getClass());
	protected Object o;
	private String priv = "priv";

	@Test
	public void t() {
		log.info(o);
		log.info(priv);
	}

	@Before
	public void b() {
		o = new Apple();
		log.info(this.o);
		m1();
	}

	private void m1() {
		log.info("m1");
		m2();
	}

	protected void m2() {
		log.info("m2");
	}
}
