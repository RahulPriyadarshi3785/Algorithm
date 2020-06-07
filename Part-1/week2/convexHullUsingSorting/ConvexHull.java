package convexHullUsingSorting;

import java.util.Arrays;

import week2.Stack;


//Find Points to cover the 2D-polygon with minimum perimeter
public class ConvexHull {
	
	public Point2D[] convexHull(Point2D[] p) {
		int len = p.length;
		if(len < 3)
			return null;
		Stack<Point2D> hull = new Stack<>();
		exchange(p, 0, Point2D.minYAxisPoint2DToFirstIndex(p));
		Arrays.sort(p, p[0].slopeOrder());
		hull.push(p[0]);
		hull.push(p[1]);
		for(int i = 2; i < len; i++) {
			Point2D top = hull.pop();
			while(Point2D.counterClockWise(hull.top(), top, p[i]) <= 0)
				top = hull.pop();
			hull.push(top);
			hull.push(p[i]);
		}
		return p;
	}
	
	private void exchange(Point2D[] p, int i, int j) {
		Point2D temp = p[i];
		p[i] = p[j];
		p[j] = temp;
		}
}
