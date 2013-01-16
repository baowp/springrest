package junit.comm;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringTest {
	private Log log = LogFactory.getLog(getClass());
	long t0, t1;

	@Test
	public void t3() {
		System.out.printf("Get %d and %s to %tc %2$s", 2, "text", new Date());
	}

	private String str = "abcdefghij";
	private int count = 10000;

	@Test
	public void testStringBuffer() {
		t0 = System.currentTimeMillis();
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < count; i++)
			sb2.append(str);
		li(sb2.toString().length());
		t1 = System.currentTimeMillis();
		log.info("StringBuffer:" + (t1 - t0));
	}

	@Test
	public void testStringBuilder() {

		t0 = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++)
			sb.append(str);
		li(sb.toString().length());
		t1 = System.currentTimeMillis();
		log.info("StringBuilder:" + (t1 - t0));

	}

	@Test
	public void testString() {
		t0 = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < count; i++) {
			s += str;
		}
		li(s.length());
		t1 = System.currentTimeMillis();
		log.info("String:" + (t1 - t0));
	}

	private void li(Object o) {
		log.info(o);
	}
}
