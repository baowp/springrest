package gc;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CollectorTest {
	Runtime run = Runtime.getRuntime();

	@Test
	public void t() {
		System.out.println(run.freeMemory());
		System.out.println(run.totalMemory());
		Garbage g = new Garbage();
		g.gar = null;
		Map<Integer, Gar> map = new HashMap<Integer, Gar>();
		map.put(1, new Gar());
		map.put(1, new Gar());
		t(0);
		System.out.println(run.freeMemory());
		System.out.println(run.totalMemory());

		run.gc();
		System.out.println(run.freeMemory());
		System.out.println(run.totalMemory());
	}

	private void t(int i) {
	}

	@Test
	public void t2() {
		t2(0);
		run.gc();
	}

	private void t2(int t) {
		int i = 0;
		Gar tempobj;

		ObjStack stack1 = new ObjStack(8);

		while (i < 8) {
			tempobj = new Gar();
			stack1.push(tempobj);
			i++;
			System.out.println(" 第" + i + "次进栈" + "\t");
		}

		while (i > 4) {
			tempobj = stack1.pop();
			i--;
			System.out.println("第" + (8 - i) + "次出栈" + "\t");
		}
	}
}
