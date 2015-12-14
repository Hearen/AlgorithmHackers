package com.sky.leetcode;
/**
* @author DuanSky
* @date 2015��12��10�� ����10:15:37
* @content 
* 	如何计算降雨量，是本题的难点。下面给出的一种解题思路是先找出最长的一根柱子，然后从两边遍历，在遍历过程中
* 记录当前最长的柱子，而其他柱子与当前最长柱子的差值即为这根柱子的储水量。
*/

public class _042_TrappingRainWater {
	
	public static void main(String args[]){
		int height[]={0,2,0};
		trap(height);
	}
	
	//TODO两个指针
	
	
	//TODO一次遍历
	
	
	//两次遍历
	public static int trap(int[] height) {
		if(height.length<=2) return 0;
	    int result=0;
	    int max=-1;int maxPos=-1;
	    for(int i=0;i<height.length;i++){
	    	if(height[i]>max){
	    		max=height[i];
	    		maxPos=i;
	    	}
	    }
	    int currentMax=height[0];
	    for(int i=0;i<maxPos;i++){
	    	if(height[i]>currentMax)
	    		currentMax=height[i];
	    	else
	    		result+=(currentMax-height[i]);
	    }
	    currentMax=height[height.length-1];
	    for(int i=height.length-1;i>maxPos;i--){
	    	if(height[i]>currentMax)
	    		currentMax=height[i];
	    	else
	    		result+=(currentMax-height[i]);
	    }
	    return result;
    } 

}
