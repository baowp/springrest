package exception;

import org.junit.Test;

public class RunTimeTest {
	@Test
	public void test() {
		new A().m();
	}

	private class A {
		private void m() {
//			try {
				new B().m();
//			} catch (Exception e) {
//				System.out.println(e);
//			}
		}
	}

	private class B {
		private void m() {
			new C().m();
		}
	}

	private class C {
		private void m() {

			throw new RuntimeException();
		}
	}
}
