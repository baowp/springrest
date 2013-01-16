package junit.comm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class CommonTest {
	private Log log = LogFactory.getLog(getClass());

	@Test
	public void t() {
		log.info(b1() | b2());
	}

	private boolean b1() {
		log.info("b1");
		return true;
	}

	private boolean b2() {
		log.info("b2");
		return false;
	}
}
