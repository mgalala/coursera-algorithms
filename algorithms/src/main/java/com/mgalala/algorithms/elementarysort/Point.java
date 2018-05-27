package com.mgalala.algorithms.elementarysort;

/**
 * 
 * @author mgalala
 *
 */
public class Point implements Comparable<Point> {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point that) {
		if (this.x > that.x) {
			return 1;
		}
		if (this.x < that.x) {
			return -1;
		}
		if (this.y > that.y) {
			return 1;
		}
		if (this.y < that.y) {
			return -1;
		}
		return 0;
	}

}