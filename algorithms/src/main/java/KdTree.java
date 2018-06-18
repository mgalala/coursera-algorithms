

import java.util.Comparator;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;

/**
 * 
 * @author mgalala
 *
 */
public class KdTree {
	private Node root;
	private int size;

	public boolean isEmpty() {
		// is the set empty?
		return root == null;
	}

	public int size() {
		// number of points in the set
		return size;
	}

	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		if (null == p) {
			throw new IllegalArgumentException();
		}

		Node current = root;
		// if the tree is empty
		if (size == 0) {
			RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
			root = new Node(p, true, null, null, rect);
			size++;
			return;
		}

		while (current != null) {
			if (same(current.point, p)) {
				return;
			}

			if (getCompartor(current).compare(p, current.point) < 0) {
				if (current.left == null) {
					RectHV rect = null;
					if (current.isVertical) {
						rect = new RectHV(current.rect.xmin(), current.rect.ymin(), current.point.x(),
								current.rect.ymax());
					} else {
						rect = new RectHV(current.rect.xmin(), current.rect.ymin(), current.rect.xmax(),
								current.point.y());
					}

					Node leftNode = new Node(p, !current.isVertical, null, null, rect);
					current.left = leftNode;
					size++;
					break;
				}
				// set current node to new left node
				current = current.left;
			} else {
				if (current.right == null) {
					RectHV rect = null;
					if (current.isVertical) {
						rect = new RectHV(current.point.x(), current.rect.ymin(), current.rect.xmax(),
								current.rect.ymax());
					} else {
						rect = new RectHV(current.rect.xmin(), current.point.y(), current.rect.xmax(),
								current.rect.ymax());
					}
					Node rightNode = new Node(p, !current.isVertical, null, null, rect);
					current.right = rightNode;
					size++;
					break;
				}
				current = current.right;

			}
		}
	}

	private Comparator<Point2D> getCompartor(Node current) {
		Comparator<Point2D> comparator;
		if (current.isVertical) {
			comparator = Point2D.X_ORDER;
		} else {
			comparator = Point2D.Y_ORDER;
		}
		return comparator;
	}

	public boolean contains(Point2D p) {
		// does the set contain point p?
		if (null == p) {
			throw new IllegalArgumentException();
		}
		return get(root, p);
	}

	private boolean get(Node current, Point2D point) {
		if (current == null) {
			return false;
		}
		Point2D currentPoint = current.point;
		if (same(point, currentPoint)) {
			return true;
		}

		if (getCompartor(current).compare(point, currentPoint) < 0) {
			return get(current.left, point);
		} else {
			return get(current.right, point);
		}
	}

	private boolean same(Point2D point, Point2D currentPoint) {
		return currentPoint.x() == point.x() && currentPoint.y() == point.y();
	}

	public void draw() {
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
		range(includedPoints, rect, root);
		return includedPoints;
	}

	private void range(Queue<Point2D> includedPoints, RectHV rect, Node currentNode) {
		if (currentNode == null) {
			return;
		}
		Point2D currentPoint = currentNode.point;
		if (rect.contains(currentPoint)) {
			includedPoints.enqueue(currentPoint);
		}

		if (currentNode.left != null && rect.intersects(currentNode.left.rect)) {
			range(includedPoints, rect, currentNode.left);
		}
		if (currentNode.right != null && rect.intersects(currentNode.right.rect)) {
			range(includedPoints, rect, currentNode.right);
		}

	}

	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p; null if the set is empty
		if (null == p) {
			throw new IllegalArgumentException();
		}
		if (isEmpty()) {
			return null;
		}
		Point2D nearest = nearest(root, p, new Point2D(100, 100));
		return nearest;
	}

	private Point2D nearest(Node node, Point2D p, Point2D nearest) {
		double distance = p.distanceTo(nearest);
		if (p.distanceTo(node.point) < distance) {
			nearest = node.point;
		}
		if (node.left != null && node.left.rect.distanceTo(p) < distance) {
			nearest = nearest(node.left, p, nearest);
			distance = p.distanceTo(nearest);
			if (node.right != null && node.right.rect.distanceTo(p) < distance) {
				nearest = nearest(node.right, p, nearest);
			}
		}
		if (node.right != null && node.right.rect.distanceTo(p) < distance) {
			nearest = nearest(node.right, p, nearest);
			distance = p.distanceTo(nearest);
			if (node.left != null && node.left.rect.distanceTo(p) < distance) {
				nearest = nearest(node.left, p, nearest);
			}
		}
		return nearest;
	}

	// create private static node class
	private class Node {
		private Point2D point;
		private RectHV rect;
		private boolean isVertical;
		private Node left;
		private Node right;

		private Node(Point2D p, boolean vertical, Node left, Node right, RectHV rectangle) {
			this.point = p;
			this.isVertical = vertical;
			this.left = left;
			this.right = right;
			this.rect = rectangle;
		}

	}

	public static void main(String[] args) {
		// unit testing of the methods (optional)
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
		System.out.println(nearest.toString());
	}
}