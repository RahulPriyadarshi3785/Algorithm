package convexHullUsingSorting;

import java.util.Comparator;

public class Point2D implements Comparator<Point2D> {

	private final double x;
	private final double y;
	
	public Comparator<Point2D> slopeOrder() {
	    return (p1, p2) -> {
	    	if(p1.x == this.x && p2.x == this.x)
				return (int) Math.floor(p1.y-p2.y);
			else if(p1.x == this.x)
				return -1;
			else if(p2.x == this.x)
				return 1;
			double slope1 = slope(p1);
			double slope2 = slope(p2);
			if(slope1 > slope2) return -1;
			else if(slope1 == slope2) return 0;
			else return 1;
	    };
	}
	
	public Point2D(double x , double y) {
		this.x = x;
		this.y = y;
	}
	
	public static int minYAxisPoint2DToFirstIndex(Point2D[] p) {
		int len = p.length;
		if(len == 0)
			return -1;
		int pmin = 0;
		for(int i = 0; i < len; i++)
			if(p[i].y < p[pmin].y) 
				pmin = i;
		return pmin;
	}
	
	public static int counterClockWise(Point2D a, Point2D b, Point2D c) {
		if(a == null)
			return 1;
		double area2Times = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
		if(area2Times < 0) return -1; //clockwise
		else if(area2Times > 0) return 1; //counter-clockwise
		else return 0; //collinear
	}

	@Override
	public int compare(Point2D p1, Point2D p2) {
		if(p1.x == this.x && p2.x == this.x)
			return (int) Math.floor(p1.y-p2.y);
		else if(p1.x == this.x)
			return -1;
		else if(p2.x == this.x)
			return 1;
		double slope1 = slope(p1);
		double slope2 = slope(p2);
		if(slope1 > slope2) return -1;
		else if(slope1 == slope2) return 0;
		else return 1;
	}
	
	private Double slope(Point2D p1) {
		return (p1.y-this.y)/(p1.x-this.x);
	}
	
}
