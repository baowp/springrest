package gc;

public class ObjStack {
	private Gar[] stack;
	private int index;

	ObjStack(int indexcount) {
		stack = new Gar[indexcount];
		index = 0;
	}

	public void push(Gar obj) {
		stack[index] = obj;
		index++;
	}

	public Gar pop() {
		index--;
		Gar temp = stack[index];
		// stack[index] = null;
		return temp;
	}

	protected void finalize() {
		System.out.println("ObjStack is reclaimed");
	}
}
