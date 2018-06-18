/**
 * 
 */
package com.mgalala.algorithms.elementarysymboltables;

/**
 * @author mgalala
 *
 */
public class JavaAutoboxingAndEquals {

	public static void main(String[] args) {
		autoboxing1();
		System.out.println("---------------------------------------------------------");
		autoboxing2();

	}

	private static void autoboxing2() {
		// Find values such that (a == b) is false, but x.equals(y) is true.
		double a = Double.NaN;
		double b = Double.NaN;
		System.out.println(a == b);

		Double x = a;
		Double y = b;
		System.out.println(x.equals(y));
	}

	private static void autoboxing1() {
		// Find values such that (a == b) is true but x.equals(y) is false.
		double a = 0.0;
		double b = -0.0;

		Double x = a;
		Double y = b;

		System.out.println(a == b);
		System.out.println(x.equals(y));
	}

}
