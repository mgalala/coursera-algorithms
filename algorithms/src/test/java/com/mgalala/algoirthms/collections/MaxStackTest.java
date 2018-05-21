/**
 * 
 */
package com.mgalala.algoirthms.collections;

import org.junit.Assert;
import org.junit.Test;

import com.mgalala.algorithms.collections.MaxStack;

/**
 * @author mgalala
 *
 */
public class MaxStackTest {

	@Test
	public void testMaxStack() {
		Integer max = null;
		MaxStack<Integer> stack = new MaxStack<>();
		int i = 1;
		int N = 10;

		while (i <= N) {
			if (i % 2 == 0) {
				max = stack.max();
			} else {
				stack.push(i);
			}
			++i;
		}
		Assert.assertEquals(9, max.intValue());
	}
}
