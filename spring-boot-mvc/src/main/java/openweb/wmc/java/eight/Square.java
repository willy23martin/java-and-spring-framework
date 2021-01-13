package openweb.wmc.java.eight;

public class Square {

	private Point[] points;

	public Square(Point p1, Point p2, Point p3, Point p4) {
		points = new Point[] { p1, p2, p3, p4 };
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}

	
	
}
