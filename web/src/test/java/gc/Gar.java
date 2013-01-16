package gc;

public class Gar {
	int index;
	static int count;

	Gar() {
		count++;
		System.out.println("Gar " + count + " construct");
		setID(count);
	}

	void setID(int id) {
		index = id;
	}

	protected void finalize() {
		System.out.println("Gar " + index + " is reclaimed");
	}
}
