package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年3月18日 下午4:07:49
 * @content 
 */

public class _210_Course_Schedule_II {
	
	public static void main(String args[]){
		_210_Course_Schedule_II test = new _210_Course_Schedule_II();
		int numCourses = 2;
		int[][] prerequisites = {};
		int[] res = test.findOrder(numCourses, prerequisites);
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
        	int from = prerequisites[i][0], to = prerequisites[i][1];
        	if(matrix[to][from]==0) indegree[from]++;
        	matrix[to][from] = 1;
        }
        
        int counter = -1;
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
        	if(indegree[i]==0) queue.add(i);
        }
        
        while(!queue.isEmpty()){
        	counter ++;
        	int curr = queue.poll();
			res[counter] = curr;
        	for(int i = 0; i < numCourses; i++){
        		if(matrix[curr][i]==1){
        			if(--indegree[i]==0){

        				queue.add(i);
        			}
        		}
        	}
        }
        return counter+1 == numCourses ? res : new int[0];
    }

}
