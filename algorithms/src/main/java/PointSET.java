
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;

/**
 * 
 * @author mgalala
 *
 */
public class PointSET {

	private TreeSet<Point2D> set;

	public PointSET() {
		// construct an empty set of points
		set = new TreeSet<>();
	}

	public boolean isEmpty() {
		// is the set empty?
		return set.isEmpty();
	}

	public int size() {
		// number of points in the set
		return set.size();
	}

	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		if (null == p) {
			throw new IllegalArgumentException();
		}
		set.add(p);
	}

	public boolean contains(Point2D p) {
		// does the set contain point p?
		if (null == p) {
			throw new IllegalArgumentException();
		}
		return set.contains(p);
	}

	public void draw() {
		// draw all points to standard draw
		if (isEmpty()) {
			return;
		}

		for (Point2D p : set) {
			p.draw();
		}
	}

	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle (or on the boundary)
		if (null == rect) {
			throw new IllegalArgumentException();
		}
		Queue<Point2D> includedPoints = new Queue<>();

		if (isEmpty()) {
			return includedPoints;
		}
		for (Point2D point2d : set) {
			if (rect.contains(point2d)) {
				includedPoints.enqueue(point2d);
			}
		}

		return includedPoints;
	}

	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p; null if the set is empty
		if (null == p) {
			throw new IllegalArgumentException();
		}
		if (isEmpty()) {
			return null;
		}

		Point2D nearestPoint = null;
		double min = Double.MAX_VALUE;
		for (Point2D point2d : set) {
			if (p.distanceTo(point2d) < min) {
				min = p.distanceTo(point2d);
				nearestPoint = point2d;
			}
		}

		return nearestPoint;
	}

	public static void main(String[] args) {
		// unit testing of the methods (optional)
		PointSET pointSET = new PointSET();
		pointSET.insert(new Point2D(1, 4));
		pointSET.insert(new Point2D(2, 4));
		pointSET.insert(new Point2D(3, 5));
		pointSET.insert(new Point2D(2, 1));
		pointSET.insert(new Point2D(3, 3));

		Point2D nearest = pointSET.nearest(new Point2D(2, 2));
		System.out.println(nearest.toString());
	}
}