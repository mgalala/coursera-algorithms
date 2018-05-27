package com.mgalala.algorithms.assignments.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author mgalala
 *
 */
public class FastCollinearPoints {
	private List<LineSegment> lineSegments;
	private List<List<Point>> items;

	public FastCollinearPoints(Point... points) {
		// finds all line segments containing 4 or more points
		if (null == points) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < points.length; i++) {
			if (points[i] == null) {
				throw new IllegalArgumentException();
			}
		}
		lineSegments = new ArrayList<>();
		items = new ArrayList<>();

		Point[] sorted = Arrays.copyOf(points, points.length);
		Arrays.sort(sorted);
		checkDoublePoints(sorted);

		// start comparing
		Point point;
		List<MyIndex> slopes;
		for (int i = 0; i < sorted.length; i++) {
			slopes = new ArrayList<>();
			Arrays.sort(sorted);

			point = sorted[i];
			Arrays.sort(sorted, point.slopeOrder());

			Point q;
			for (int j = i + 1; j < sorted.length; j++) {
				q = sorted[j];
				slopes.add(new MyIndex(j, point.slopeTo(q)));
			}
			List<Integer> duplicates = duplicates(slopes);
			if (duplicates.size() >= 3) {

				List<Point> tmpConnectedPoints = new ArrayList<>();
				tmpConnectedPoints.add(point);
				for (Integer indexToAdd : duplicates) {
					tmpConnectedPoints.add(sorted[indexToAdd]);
				}

				LineSegment lineToAdd = null;
				if (items.isEmpty()) {
					lineToAdd = initLineToAdd(point, tmpConnectedPoints);
					lineSegments.add(lineToAdd);
				} else {
					for (List<Point> connectedPoints : items) {
						if (!connectedPoints.containsAll(tmpConnectedPoints)) {
							lineToAdd = initLineToAdd(point, tmpConnectedPoints);
							lineSegments.add(lineToAdd);
						}
					}
				}

				if (lineToAdd != null) {
					items.add(tmpConnectedPoints);
				}
			}

		}
	}

	private LineSegment initLineToAdd(Point point, List<Point> tmpConnectedPoints) {
		LineSegment lineToAdd;
		Point q2 = tmpConnectedPoints.get(tmpConnectedPoints.size() - 1);
		lineToAdd = new LineSegment(point, q2);
		return lineToAdd;
	}

	private List<Integer> duplicates(final List<MyIndex> slopesList) {
		List<Integer> duplicated = new ArrayList<>();
		for (MyIndex entry : slopesList) {
			if (duplicated.size() > 1) {
				break;
			}
			boolean meAdded = false;
			Double filterTerm = entry.getSlope();
			for (MyIndex entry2 : slopesList) {
				if (entry.getIndex() != entry2.getIndex() && entry2.getSlope().equals(filterTerm)) {
					if (!meAdded) {
						duplicated.add(entry.getIndex());
						meAdded = true;
					}
					duplicated.add(entry2.getIndex());
				}
			}
		}

		return duplicated;
	}

	private void checkDoublePoints(Point... points) {
		Point previous = null;
		for (Point point : points) {
			if (previous != null && previous.compareTo(point) == 0) {
				throw new IllegalArgumentException();
			}
			previous = point;
		}
	}

	public int numberOfSegments() {
		// the number of line segments
		return lineSegments.size();
	}

	public LineSegment[] segments() {
		// the line segments
		return lineSegments.toArray(new LineSegment[lineSegments.size()]);
	}

	private class MyIndex {
		private Integer index;
		private Double slope;

		public MyIndex() {

		}

		public MyIndex(Integer i, Double s) {
			this.index = i;
			this.slope = s;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public Double getSlope() {
			return slope;
		}

		public void setSlope(Double slope) {
			this.slope = slope;
		}

	}
}