/**
 * 
 */
package com.mgalala.algorithms.collections;

import java.util.Stack;

/**
 * @author mgalala
 *
 */
public class MyStack {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();
		String input = "to be or not to - be - - that - - - is";
		String[] split = input.split(" ");
		for (String s : split) {
			if (s.equals("-"))
				System.out.print(stack.pop() + " ");
			else
				stack.push(s);
			// stack: to is
			// out: to be not that or be
		}

		System.out.println("items in the stack ");
		for (String item : stack) {
			System.out.println(item);
		}
	}
}
