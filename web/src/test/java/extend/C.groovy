package extend

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

class C extends B{
	
	@Test
	void t() {
		log.info(o);
		log.info(super.o == o);
		log.info(bl());
	}
	
	boolean bl(){
		File file=new File("");
		FileUtils.deleteDirectory(file);
	}
}
