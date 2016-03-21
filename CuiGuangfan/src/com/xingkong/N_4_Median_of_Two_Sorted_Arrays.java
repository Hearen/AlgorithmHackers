package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年2月29日 上午8:34:16 
* class description
*/
public class N_4_Median_of_Two_Sorted_Arrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//return recursion(nums1,nums2,0,nums1.length-1,0,nums2.length-1,0,0,true);
		return 0;
	}
	public static double recursion(int[] nums1, int[] nums2,int n1Begin,int n1End,int n2Begin,int n2End,int n1Sum,int n2Sum){
		if(n1Sum+n2Sum==nums1.length+nums2.length-3){
			
		}
		if(n1Sum+n2Sum==nums1.length+nums2.length-3){
			
		}
		int n1Mid=(n1Begin+n1End)/2;
		int n2Mid=(n2Begin+n2End)/2;
		if(nums1[n1Mid]>nums2[n2Mid]){
			return recursion(nums1,nums2,n1Begin,n1Mid,n2Mid,n2End,n1Sum+n1End-n1Mid,n2Sum+n2Mid-n2Begin);
		}else if(nums1[n1Mid]<nums2[n2Mid]){//
			return recursion(nums1,nums2,n1Mid,n1End,n2Begin,n2Mid,n1Sum+n1Mid-n1Begin,n2Sum+n2End-n2Mid);
		}else{
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a1=new int[]{4,9,11,13,14,15};
		int[]a2=new int[]{5,8,9,10,12};
		int[]a3=new int[]{4,9,10,11};
		int[]a4=new int[]{5,6,7,8};
		int[]a5=new int[]{1,2,3};
		int[]a6=new int[]{4,5,6};
		System.out.println(N_4_Median_of_Two_Sorted_Arrays.findMedianSortedArrays(
				a3, 
				a4));
	}

}
