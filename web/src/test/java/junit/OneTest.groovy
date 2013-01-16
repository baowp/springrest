package junit;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class OneTest {

	int i;
	int getI(){
		return 2;
	}
	OneTest(){
		println "oneTest"
	}
	@Before 
	public void b() {
		def be= "be"
		println(be)
	}
	@Test
	void aa(){
		println "oneTest2";
		Map	map=new HashMap();
		map.put "key" , "value4"
		//map=":"
		println map.get("key")
		List<Integer> list=new ArrayList<>();
		list.add 1;
		list.add 2;
		list.add 3
		list.findAll{it}.each {println it}
	}

	void t(int ...i){
		println();
	}
}
