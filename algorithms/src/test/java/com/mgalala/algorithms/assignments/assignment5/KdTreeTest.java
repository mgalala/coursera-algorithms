/**
 * 
 */
package com.mgalala.algorithms.assignments.assignment5;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * @author mgalala
 *
 */
public class KdTreeTest {
	private final static Logger LOGGER = Logger.getLogger(KdTreeTest.class.getName());

	@Test
	public void testRange() {
		KdTree pointSET = new KdTree();
		pointSET.insert(new Point2D(0.5, 0.875));
		pointSET.insert(new Point2D(0.875, 0.0));
		pointSET.insert(new Point2D(0.625, 0.5));
		pointSET.insert(new Point2D(0.375, 0.125));
		pointSET.insert(new Point2D(0.125, 0.25));
		// [0.25, 0.75] x [0.375, 1.0]
		Iterable<Point2D> range = pointSET.range(new RectHV(0.25, 0.375, 0.75, 1.0));
		int size = 0;
		for (Point2D point2d : range) {
			size++;
			LOGGER.info(point2d.toString());
		}

		Assert.assertEquals(2, size);
	}

	@Test
	public void testNearest() {
		KdTree pointSET = new KdTree();
		pointSET.insert(new Point2D(0.158530, 0.486901));
		pointSET.insert(new Point2D(0.792202, 0.762825));
		pointSET.insert(new Point2D(0.738013, 0.827616));
		pointSET.insert(new Point2D(0.615232, 0.064454));
		pointSET.insert(new Point2D(0.107092, 0.863317));
		pointSET.insert(new Point2D(0.395908, 0.043916));
		pointSET.insert(new Point2D(0.848473, 0.112317));
		pointSET.insert(new Point2D(0.095420, 0.786050));
		pointSET.insert(new Point2D(0.684045, 0.631946));
		pointSET.insert(new Point2D(0.771410, 0.386939));
		pointSET.insert(new Point2D(0.997176, 0.122313));
		pointSET.insert(new Point2D(0.758012, 0.929986));
		pointSET.insert(new Point2D(0.762533, 0.084336));
		pointSET.insert(new Point2D(0.533326, 0.509709));
		pointSET.insert(new Point2D(0.636874, 0.972299));
		pointSET.insert(new Point2D(0.950162, 0.341602));
		pointSET.insert(new Point2D(0.441805, 0.922723));
		pointSET.insert(new Point2D(0.374015, 0.653670));
		pointSET.insert(new Point2D(0.778271, 0.564235));
		pointSET.insert(new Point2D(0.671664, 0.493681));
		pointSET.insert(new Point2D(0.052601, 0.617204));
		pointSET.insert(new Point2D(0.924451, 0.805943));
		pointSET.insert(new Point2D(0.765215, 0.477260));
		pointSET.insert(new Point2D(0.202208, 0.132361));
		pointSET.insert(new Point2D(0.515627, 0.743434));
		pointSET.insert(new Point2D(0.726965, 0.074768));
		pointSET.insert(new Point2D(0.811187, 0.699469));
		pointSET.insert(new Point2D(0.279975, 0.219012));
		pointSET.insert(new Point2D(0.432028, 0.086015));
		pointSET.insert(new Point2D(0.761284, 0.565975));

		Point2D nearest = pointSET.nearest(new Point2D(0.201455, 0.614122));
		Assert.assertEquals(0.15853, nearest.x(), 0);
		Assert.assertEquals(0.486901, nearest.y(), 0);

	}
}
