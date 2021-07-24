package com.xt.game;

public class Point {
	public double x, y;
	public int m, n;

	public Point() {
	}

	public int hash;
	
	public String toString(){
		return"";
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		m = getPoint(x);
		n = getPoint(y);
	}

	public Point(int m, int n) {
		this.m = m;
		this.n = n;
		x = getCoordintes(m);
		y = getCoordintes(n);
	}

	public static int getPoint(double coordintes) {
		return (int) Math.rint((coordintes - ChessFrame.lineSize)
				/ ChessFrame.size);
	}

	public static double getCoordintes(int point) {
		return point * ChessFrame.size + ChessFrame.lineSize;
	}

	@Override
	public int hashCode() {

		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;

		if (m == other.m && n == other.n)
			return true;
		return false;
	}

}
