package com.cz.algorithm.learn.two;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {

	public int maxPoints(Point[] points) {
		if(points  == null) return 0;
		int len = points.length;
		if (len < 3)
			return len;
		int result = 0;
		Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
		for (int i = 0; i < len; i++) {
			slopeMap.clear();
			int duplicate = 1;
			double slope = 0.0;
			for (int j = 0; j < len; j++) {
				 if (i == j) continue;
				 if (points[i].x == points[j].x && points[i].y == points[j].y) {
					  duplicate++;  
	                   continue;  
				 } else if (points[i].x == points[j].x) {
					 slope = Integer.MAX_VALUE;  
					} else {
						slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
					} 
				 slopeMap.put(slope, slopeMap.containsKey(slope) ? slopeMap.get(slope) + 1 : 1);  
				}
			    if(slopeMap.keySet().size() == 0) {
			    	result = duplicate > result ? duplicate : result;
			    } else {
			    	for (double key : slopeMap.keySet()) {  
			    		result = Math.max((duplicate + slopeMap.get(key)), result);   
	                }  
			    }
			}
		return result;
	}

	class Point {
		int x;
		int y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
