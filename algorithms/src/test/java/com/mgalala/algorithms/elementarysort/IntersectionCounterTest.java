/**
 * 
 */
package com.mgalala.algorithms.elementarysort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mgalala
 *
 */
public class IntersectionCounterTest {
	private IntersectionCounter intersectionCounter;

	@Test
	public void testIntersectionCounter() {
		Point[] first = { new Point(1, 2), new Point(1, 5), new Point(2, 7) };
		Point[] second = { new Point(1, 2), new Point(4, 7), new Point(1, 5) };

		intersectionCounter = new IntersectionCounter();
		Assert.assertEquals(2, intersectionCounter.count(first, second));
	}
}
