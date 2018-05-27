/**
 * 
 */
package com.mgalala.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mgalala
 *
 */
public class SortTest {

	/*
	 * ASCII table
	 */
	@Test
	public void testCharDiff() {
		Character c1 = 'a';
		Character c2 = 'f';
		System.out.println(c2 - c1);

		char x = 88;
		System.out.println(x);
		Assert.assertEquals('X', x);

		int E = 'E';
		System.out.println(E);
		Assert.assertEquals(69, E);

		int number = 8 + 'E';
		System.out.println(number);
		Assert.assertEquals(77, number);

		char[] chars = Character.toChars(number);
		Assert.assertEquals('M', chars[0]);

		int a = 'a';
		Assert.assertEquals(97, a);
		System.out.println(a);

		char y = 'a' + 8;
		Assert.assertEquals('i', y);
		System.out.println(y);

		char co = 105;
		Assert.assertEquals('i', co);
		System.out.println(co);
		
		
	}
}
