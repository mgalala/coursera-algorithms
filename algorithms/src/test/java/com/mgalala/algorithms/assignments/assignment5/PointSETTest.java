/**
 * 
 */
package com.mgalala.algorithms.assignments.assignment5;

import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * @author mgalala
 *
 */
public class PointSETTest {

	@Test
	public void testNearest() {
		PointSET pointSET = new PointSET();
		pointSET.insert(new Point2D(1, 4));
		pointSET.insert(new Point2D(2, 4));
		pointSET.insert(new Point2D(3, 5));
		pointSET.insert(new Point2D(2, 1));
		pointSET.insert(new Point2D(3, 3));

		Point2D nearest = pointSET.nearest(new Point2D(2, 2));
		Assert.assertEquals(2, nearest.x(), 0);
		Assert.assertEquals(1, nearest.y(), 0);
	}

	@Test
	public void testRange() {
		PointSET pointSET = new PointSET();
		pointSET.insert(new Point2D(1, 4));
		pointSET.insert(new Point2D(3, 5));
		pointSET.insert(new Point2D(2, 1));
		pointSET.insert(new Point2D(3, 3));

		RectHV rect = new RectHV(0, 3, 2, 5);
		Iterable<Point2D> actual = pointSET.range(rect);

		for (Point2D point2d : actual) {
			Assert.assertEquals(1, point2d.x(), 0);
			Assert.assertEquals(4, point2d.y(), 0);
		}

	}
}
