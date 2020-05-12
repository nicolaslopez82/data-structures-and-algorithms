package com.nicolaslopez82.dsa.algorithmicproblems.closestpairofpoints;

import java.util.Comparator;

public class XSorter implements Comparator<Point>{

	@Override
	public int compare(Point point, Point otherPoint) {
		return Double.compare(point.getX(), otherPoint.getX());
	}
}
