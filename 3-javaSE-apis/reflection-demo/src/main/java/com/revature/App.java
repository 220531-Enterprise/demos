package com.revature;

import com.revature.inspection.ClassInspector;
import com.revature.models.Animal;

public class App {

	public static void main(String[] args) {
		
		ClassInspector.inspectClass(Animal.class); 
		// inspecting the java byte code AS it's being run (after compilation)
		// Animal.java -> (javac compilier compiles that to Animal.class) -- that's java bytecode
		// java byte code gets executed by the JIT Compiler in the JVM
		

	}

}
