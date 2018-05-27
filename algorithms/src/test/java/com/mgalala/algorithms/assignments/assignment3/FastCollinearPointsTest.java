/**
 * 
 */
package com.mgalala.algorithms.assignments.assignment3;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mgalala
 *
 */
public class FastCollinearPointsTest {
	private FastCollinearPoints fastCollinearPoints;

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		fastCollinearPoints = new FastCollinearPoints(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullPoint() {
		fastCollinearPoints = new FastCollinearPoints(null, new Point(1, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDoublePoint() {
		fastCollinearPoints = new FastCollinearPoints(new Point(1, 1), new Point(1, 1));

	}

	@Test
	public void testFoundOne() {
		fastCollinearPoints = new FastCollinearPoints(new Point(1, 1), new Point(2, 2), new Point(3, 3),
				new Point(4, 4));
		Assert.assertEquals(1, fastCollinearPoints.numberOfSegments());
	}

	@Test
	public void testFoundTwo() {
		fastCollinearPoints = new FastCollinearPoints(new Point(1, 1), new Point(3, 8), new Point(2, 2),
				new Point(3, 3), new Point(4, 4), new Point(7, 2), new Point(1, 5), new Point(2, 5), new Point(3, 5),
				new Point(4, 5), new Point(5, 5));
		Assert.assertEquals(2, fastCollinearPoints.numberOfSegments());
	}

	@Test
	public void testFoundHorizontal() {
		fastCollinearPoints = new FastCollinearPoints(new Point(1, 1), new Point(2, 1), new Point(3, 1),
				new Point(4, 1));
		Assert.assertEquals(1, fastCollinearPoints.numberOfSegments());
	}

	@Test
	public void testFoundVertical() {
		fastCollinearPoints = new FastCollinearPoints(new Point(1, 1), new Point(1, 2), new Point(1, 3),
				new Point(1, 4));
		Assert.assertEquals(1, fastCollinearPoints.numberOfSegments());
	}

	@Test
	public void testNotFound() {
		fastCollinearPoints = new FastCollinearPoints(new Point(1, 1), new Point(1, 2), new Point(1, 3),
				new Point(3, 4));
		Assert.assertEquals(0, fastCollinearPoints.numberOfSegments());
	}
}
