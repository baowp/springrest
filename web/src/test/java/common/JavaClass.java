package common;

public class JavaClass {

	public static void main(String args[]) {
		String a = "a";
		String s = a + "b";
		System.out.println(s);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);

		try {
			Float.parseFloat(null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
