package gc;

public class Garbage {
	int index;
	static int count;
	Gar gar = new Gar();

	Garbage() {
		count++;
		System.out.println("Garbage " + count + " construct");
		setID(count);
	}

	void setID(int id) {
		index = id;
	}

	protected void finalize() {
		System.out.println("Garbage " + index + " is reclaimed");
	}

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println(run.freeMemory() / 1024 / 1024);
		System.out.println(run.availableProcessors());
		new Gar();
		new Gar();
		m();
		System.gc();
		new Garbage();
	}

	private static void m() {
		ClassLoader loader = new ClassLoader() {
		};
		try {
			Class<?> clazz = loader.loadClass("gc.Gar");
			System.out.println(clazz.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
