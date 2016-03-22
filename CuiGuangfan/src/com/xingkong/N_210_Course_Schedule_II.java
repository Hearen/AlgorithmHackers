package com.xingkong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月17日 上午8:37:34 
* class description
*/
public class N_210_Course_Schedule_II {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		 List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();  
	        for (int i = 0; i < numCourses; i++) {  
	            adjLists.add(new HashSet<Integer>());  
	        }  
	          
	        for (int i = 0; i < prerequisites.length; i++) {  
	            adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);  
	        }  
	          
	        int[] indegrees = new int[numCourses];  
	        for (int i = 0; i < numCourses; i++) {  
	            for (int x : adjLists.get(i)) {  
	                indegrees[x]++;  
	            }  
	        }  
	          
	        Queue<Integer> queue = new LinkedList<Integer>();  
	        for (int i = 0; i < numCourses; i++) {  
	            if (indegrees[i] == 0) {  
	                queue.offer(i);  
	            }  
	        }  
	          
	        int[] res = new int[numCourses];  
	        int count = 0;  
	        while (!queue.isEmpty()) {  
	            int cur = queue.poll();  
	            for (int x : adjLists.get(cur)) {  
	                indegrees[x]--;  
	                if (indegrees[x] == 0) {  
	                    queue.offer(x);  
	                }  
	            }  
	            res[count++] = cur;  
	        }  
	          
	        if (count == numCourses) return res;  
	        return new int[0];  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_210_Course_Schedule_II n=new N_210_Course_Schedule_II();
		int[] temp=n.findOrder(2, new int[][]{{0,1},{1,0}});//{1,0},{2,0},{3,1},{3,2}
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]+" ");
	}

}
