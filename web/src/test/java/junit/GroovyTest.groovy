package junit

import org.junit.Test

class GroovyTest {
	@Test
	void t(){
		def str="str2";
		println("print out ${str}")

		Person y = new Person()
		y.setName str;
		println y.name
		
		Map map;
		if(!map){
			map=new HashMap();
			map.put 'str2', 'a';
		}
		if(!map){
			throw new Exception();
		}else{
			println(map[str])
		}
		

		List<Integer> list=new ArrayList();
		list.add 1;
		list.add('a');
		list << 'b'
		list.each {
			println it;
			y?.out(it);
		}
		
		def range=0..10;
		println(range)

		def closure = { param ->
			param+="sdf";
			println("hello ${param}")
		}
		closure.call("world!")
		t2(closure)
		
		SpelTest st=new SpelTest();
		println st.test("log");
	}
	void t2(callback){
		callback("closure")
	}
	class Person   {
		String name
		String getName(){
			if(name)
				return name;
			return "name";
		}
		private void out(e){
			println("person.out")
		}
	}

	def invokeMethod(){
		println("invoked");
	}
}
