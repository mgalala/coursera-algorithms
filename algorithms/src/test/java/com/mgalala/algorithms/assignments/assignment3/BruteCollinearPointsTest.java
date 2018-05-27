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
public class BruteCollinearPointsTest {
	private BruteCollinearPoints bruteCollinearPoints;

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		bruteCollinearPoints = new BruteCollinearPoints(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullPoint() {
		bruteCollinearPoints = new BruteCollinearPoints(null, new Point(1, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDoublePoint() {
		bruteCollinearPoints = new BruteCollinearPoints(new Point(1, 1), new Point(1, 1));

	}

	@Test
	public void testFoundOne() {
		bruteCollinearPoints = new BruteCollinearPoints(new Point(1, 1), new Point(2, 2), new Point(3, 3),
				new Point(4, 4));
		Assert.assertEquals(1, bruteCollinearPoints.numberOfSegments());
	}

	@Test
	public void testFoundHorizontal() {
		bruteCollinearPoints = new BruteCollinearPoints(new Point(1, 1), new Point(2, 1), new Point(3, 1),
				new Point(4, 1));
		Assert.assertEquals(1, bruteCollinearPoints.numberOfSegments());
	}

	@Test
	public void testFoundVertical() {
		bruteCollinearPoints = new BruteCollinearPoints(new Point(1, 1), new Point(1, 2), new Point(1, 3),
				new Point(1, 4));
		Assert.assertEquals(1, bruteCollinearPoints.numberOfSegments());
	}

	@Test
	public void testNotFound() {
		bruteCollinearPoints = new BruteCollinearPoints(new Point(1, 1), new Point(1, 2), new Point(1, 3),
				new Point(3, 4));
		Assert.assertEquals(0, bruteCollinearPoints.numberOfSegments());
	}
}
