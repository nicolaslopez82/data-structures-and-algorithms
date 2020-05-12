package com.nicolaslopez82.dsa.algorithmicproblems.closestpairofpoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CLOSEST PAIR OF POINTS
 *
 * - We are given an array of N points in the 2-D plane and the problem is to find the closest
 *   pair of points in the array.
 *
 * - It has several applications: for example air-traffic control.
 *
 * - We may want to monitor planes that come too close together  they might collide.
 *
 * - Brute-force approach: O(N) is very slow, so we need something faster.
 *
 * - Divide and conquer approach might help to achieve O(N*logN) time complexity.
 *
 * //=======================================================================================//
 *
 * 1.) sort all points according to the x coordinates.
 * 2.) Divide all points into two subsets with the help of a middleIndex.
 * 3.) Find the minimum distance recursively in the two subsets // d1 and d2.
 * 4.) Calculate the minimum of these smallest distances // d = min(d1,d2).
 * 5.) Check the neighbourhood of the middle line (strip) there may be points that are closer to each other
 *     than min(d1,d2). So we get a stripMinimum.
 * 6.) Find the smallest distance in the strip.
 * 7.) Finally return min(d,stripMinimum).
 *
 */

public class Algorithm {

	private List<Point> points;

	public Algorithm(List<Point> points) {
		this.points = points;
	}
	
	public double solveProblem(){
		
		List<Point> sortedXPoints = new ArrayList<>();
		List<Point> yPoints = new ArrayList<>();
		
		for(Point point : this.points){
			sortedXPoints.add(point);
			yPoints.add(point);
		}
		
		sortByX(sortedXPoints);
		
		return findClosestPoints(sortedXPoints, yPoints, sortedXPoints.size());
	}
	
	public double findClosestPoints(List<Point> pointsSortedX, List<Point> pointsY, int numOfPoints){
		
		if( numOfPoints <= 3 ) return bruteForceApproach(pointsSortedX);
		
		int middleIndex = numOfPoints / 2;
		
		Point middlePoint = pointsSortedX.get(middleIndex);
		
		List<Point> leftSubPointsY = new ArrayList<>();
		List<Point> leftSubPointsSortedX = new ArrayList<>();
		List<Point> rightSubPointsY = new ArrayList<>();
		List<Point> rightSubPointsSortedX = new ArrayList<>();
		
		// divide the point to left and right subarrays
		for(int index=0;index<numOfPoints;++index){
			if( pointsY.get(index).getX() <= middlePoint.getX() ){
				leftSubPointsY.add(pointsY.get(index));
				leftSubPointsSortedX.add(pointsSortedX.get(index));
			}else{
				rightSubPointsY.add(pointsY.get(index));
				rightSubPointsSortedX.add(pointsSortedX.get(index));
			}
		}
		
		double sigmaLeft = findClosestPoints(leftSubPointsSortedX, leftSubPointsY, middleIndex);
		double sigmaRight = findClosestPoints(rightSubPointsSortedX, rightSubPointsY, numOfPoints-middleIndex);
		double sigma = Math.min(sigmaLeft, sigmaRight);
		
		List<Point> pointsInStrip = new ArrayList<>();
		
		for(int index=0;index<numOfPoints;++index){
			if( Math.abs(pointsY.get(index).getX() - middlePoint.getX()) < sigma ){
				pointsInStrip.add(pointsY.get(index));
			}
		}
		
		double minDistanceStrip = findMinimumDistanceInStrip(pointsInStrip, sigma);
	
		return Math.min(sigma, minDistanceStrip);
	}

	public double bruteForceApproach(List<Point> points) {
		
		double minDistance = Double.MAX_VALUE;
		
		for(int i=0;i<points.size();++i){
			for(int j=i+1;j<points.size();++j){
				if( distance(points.get(i), points.get(j)) < minDistance ){
					minDistance = distance(points.get(i), points.get(j));
				}
			}
		}
		
		return minDistance;
	}

	private double findMinimumDistanceInStrip(List<Point> pointsInStrip, double sigma) {
		
		double minDistance = sigma;
		
		for(int i=0;i<pointsInStrip.size();++i){
			for(int j=i+1; j<pointsInStrip.size() && (pointsInStrip.get(j).getY() - pointsInStrip.get(i).getY())<minDistance;++j){				
				if( distance(pointsInStrip.get(i), pointsInStrip.get(j)) < minDistance ) {
					minDistance = distance(pointsInStrip.get(i), pointsInStrip.get(j));
				}
			}
		}
		
		return minDistance;
	}

	private void sortByX(List<Point> points){
		Collections.sort(points, new XSorter());
	}
	
	private double distance(Point point1, Point point2){
		double xDistance = Math.abs( point1.getX() - point2.getX() );
		double yDistance = Math.abs( point1.getY() - point2.getY() );
		return Math.sqrt(xDistance*xDistance + yDistance*yDistance);
	}
}
