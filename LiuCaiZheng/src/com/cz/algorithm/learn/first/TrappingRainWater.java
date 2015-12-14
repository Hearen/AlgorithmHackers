package com.cz.algorithm.learn.first;

public class TrappingRainWater {

	public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(A));
	}
	
//	public static int trap(int[] A) {
//		int left = 0;
//		int right = A.length - 1;  //
//		int sum = 0;    //the sum of the rain
//		int pre = 0;     //recode the previous one or more 
//		while(left < right) {
//			
//		}
//		return 0;
//	}

	public static  int trap(int[] A) {
		 int left = 0 , right = A.length-1;
	        int sum = 0;
	        int pre = 0;
	        while(left < right){
	            sum += (Math.min(A[left], A[right])-pre) * (right-left-1);
	            pre = Math.min(A[left],A[right]);
	            if(A[left] > A[right]){ 
	                int temp = right-1;
	                while(left < temp && A[temp] <= pre){sum-=A[temp];temp--;}
	                if(left < temp) sum -= pre;
	                right = temp;
	            }else{
	                int temp = left+1;
	                while(temp < right && A[temp] <= pre){sum-=A[temp];temp++;}
	                if(temp < right) sum -= pre;
	                left = temp;
	            }
	        }
	        return sum;
	}
}
