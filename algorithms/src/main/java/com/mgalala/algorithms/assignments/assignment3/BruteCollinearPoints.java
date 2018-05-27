package com.mgalala.algorithms.assignments.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 
 * @author mgalala
 *
 */
public class BruteCollinearPoints {
	private List<LineSegment> lineSegments;

	public BruteCollinearPoints(Point... points) {
		if (null == points) {
			throw new IllegalArgumentException();
		}

		if (Stream.of(points).anyMatch(Objects::isNull)) {
			throw new IllegalArgumentException();
		}
		lineSegments = new ArrayList<>();

		Arrays.sort(points);
		checkDoublePoints(points);
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					int lastIndex = points.length - 1;
					Point iPoint = points[i];
					Point jPoint = points[j];
					Point kPoint = points[k];
					Point lastPoint = points[lastIndex];

					double firstSlope = iPoint.slopeTo(jPoint);
					double secondSlope = jPoint.slopeTo(kPoint);
					double thirdSlope = kPoint.slopeTo(points[lastIndex]);
					double bigSlope = iPoint.slopeTo(points[lastIndex]);

					if ((firstSlope == secondSlope) && (secondSlope == thirdSlope) && (thirdSlope == bigSlope)) {
						lineSegments.add(new LineSegment(iPoint, lastPoint));
					}
				}
			}
		}

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
}
