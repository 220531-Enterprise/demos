package com.revature.inspection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * Reflection is the process of inspecting and/or modifying the behavior of a
 * class at runtime by way of the methods found in the Reflection API (part of the
 * JRE) java.lang.reflect package.
 *
 * The purpose of this class will be to INSPECT the properties of a class at
 * runtime using the inspectClass() method.
 */
public class ClassInspector {
	
	// this is just a method to combine the output of both methods 
	public static void inspectClass(Class<?> clazz) {
		
		listPublicFields(clazz);
		listNonPublicFields(clazz);
		listDeclaredMethods(clazz);
		
	}

	// the purpose of this method is to print all
	public static void listPublicFields(Class<?> clazz) {

		System.out.println("Printing out all the public fields of the class " + clazz.getSimpleName());

		// capture an array of the fields that belong to a class
		Field[] fields = clazz.getFields();

		// iterate over each field and check if they're public
		for (Field field : fields) {

			if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {

				// if they are public, print out their info: name, type, is it primitive?, bit
				// value
				System.out.println("\tField name: " + field.getName());
				System.out.println("\tField type: " + field.getType());
				System.out.println("\tIs the field primitive? " + field.getType().isPrimitive());
				// bit vlaue of public etc...
				System.out.println("\tModifier's bit value: " + Integer.toBinaryString(field.getModifiers()));
				System.out.println();
			}

		}
	}

	// Accept a class of any type and print its fields as long as they're NOT public
	public static void listNonPublicFields(Class<?> clazz) {

		System.out.println("Printing out all the NON-public fields of the class " + clazz.getSimpleName());

		// capture an array of the fields that belong to a class
		Field[] fields = clazz.getDeclaredFields(); // this should return private fields

		// iterate over each field and check if they're public
		for (Field field : fields) {

			if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {			
				continue; // this prevents us from breaking DOWN to line 69 - 73
			}

			// if they are public, print out their info: name, type, is it primitive?, bit
			// value
			System.out.println("\tField name: " + field.getName());
			System.out.println("\tField type: " + field.getType());
			System.out.println("\tIs the field primitive? " + field.getType().isPrimitive());
			// bit vlaue of public etc...
			System.out.println("\tModifier's bit value: " + Integer.toBinaryString(field.getModifiers()));
			System.out.println();
		}
	}
	
	public static void listDeclaredMethods(Class<?> clazz) {
		
		System.out.println("List all the declared methods of the class");
		
		Method[] methods = clazz.getDeclaredMethods();
	
		for (Method method : methods) {
			
			System.out.println("\tName: " + method.getName());
			// capture parameter types that are passed thru the method
			Class<?>[] parameterTypes = method.getParameterTypes();
			System.out.println("\tDeclared annotations " + Arrays.toString(method.getDeclaredAnnotations()));
			
			
			Parameter[] params = method.getParameters();
			// name, type, and annotations over the parameters themselves
			
			
		}
	}

}
