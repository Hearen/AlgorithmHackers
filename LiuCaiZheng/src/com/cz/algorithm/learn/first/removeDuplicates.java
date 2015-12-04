package com.cz.algorithm.learn.first;

public class removeDuplicates {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3 };
		System.out.println(removeDuplicate(nums));
	}
	
	/*
	 * return the lentgh of the array.
	 * */
	 public static int removeDuplicate(int[] A) {
		   int n = A.length;
		   if(n==0)return 0;
	        if(n==1)return 1;
	        int num=1,i,temp=A[1];
	        for(i=2;i<n;++i)
	            if(A[i]!=A[i-2]) {
	                A[num++]=temp;
	                temp=A[i];
	            }
	        A[num++]=temp;
	        return num;
	}
	
	 /**
	  * compare from the last elements.
	  * */
//	 public int removeDuplicates(int[] A) {
//		    if(A.length ==0){
//		      return 0;
//		    }
//		    int count=1;
//		    for(int i=1; i<A.length; ++i){
//		      if(A[i] != A[i-1]){ //注意这行代码
//		        A[count]=A[i];
//		        count++;
//		      }
//		    }
//		    return count;
//		  }

}
