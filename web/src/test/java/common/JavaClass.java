package common;


public class JavaClass {

	public static void main(String args[]) {
		String a = "a";
		String s = a + "b";
		System.out.println(s);

		try {
			 Float.parseFloat(null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
