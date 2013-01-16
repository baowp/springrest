package common

class GroovyOne {

	static main(args) {
		def closure = {
			println "closure";
			return it
		}
		closure(2); 
		println closure(2)
	}
}
