package junit;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.iteye.baowp.springrest.constant.Const;
import com.iteye.baowp.springrest.util.Spel;

public class SpelTest {
	private Log log = LogFactory.getLog(getClass());

	@Test
	public void t() {
		Const obj[] = Const.class.getEnumConstants();
		for (Const o : obj) {
			log.info(o);
		}
	}

	@Test
	public void test() throws ClassNotFoundException, LinkageError {
		log.info(com.iteye.baowp.springrest.constant.Constant.str);
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser
				.parseExpression("com.javabloger.springrest.constant.Constant.str");
		String message = (String) exp.getValue();
		log.info(message);
	}

	@Test
	public void t2() {
		ExpressionParser parser = new SpelExpressionParser();
		Simple simple = new Simple();
		simple.booleanList.add(true);
		StandardEvaluationContext simpleContext = new StandardEvaluationContext(
				simple);
		// false is passed in here as a string. SpEL and the conversion service
		// will
		// correctly recognize that it needs to be a Boolean and convert it
		Expression exp = parser.parseExpression("str2('a')");
		log.info(exp.getValue(simpleContext));
		exp.setValue(simpleContext, "false");

		Boolean b = simple.booleanList.get(0);
		log.info(b);
	}

	static class Simple {
		public List<Boolean> booleanList = new ArrayList<Boolean>();
		public static String str = "s";

		public static String str2(String s) {
			return s;
		}
	}

	@Test
	public void t3() {
		Object message = null;
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("T(junit.SpelTest$En).b()");
		try {
			message = exp.getValue();
		} catch (Exception e) {
			log.info(e);
		}
		log.info(message);
	}

	@Test
	public void t4() {
		log.info(a(2, 3));
		Spel spel = Spel.getSpel();
		String key = "2 & 1";
		log.info(spel.get(key));
	}

	private boolean a(Integer... ing) {
		if (ing.length > 1) {
			int a = ing[0];
			for (int i = 1; i < ing.length; i++) {
				a = a & ing[i];
			}
			return a == 0 ? false : true;
		}
		return false;
	}

	enum En {
		en, cn;

		public static boolean b() {
			return true;
		}
	}

	@SuppressWarnings("unused")
	private void test(String s) {
		log.info(s);
	}

}
