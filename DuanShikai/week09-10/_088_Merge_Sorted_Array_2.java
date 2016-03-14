package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年2月29日 下午2:13:58
 * @content 
 */

public class _088_Merge_Sorted_Array_2 {
	
	public static void main(String args[]){
		_088_Merge_Sorted_Array_2 test = new _088_Merge_Sorted_Array_2();
		int[] nums1={1,2,3,4,5,0};
		int[] nums2={3};
		int m=5,n=1;
		test.merge_1(nums1, m, nums2, n);
	}
	
	//这样从后往前遍历，省去了元素往后移动的操作步骤。0ms
	public void merge_1(int[] nums1,int m,int[] nums2,int n){
		int p1=m-1,p2=n-1,p=m+n-1;
		while(p1>=0 && p2>=0){
			if(nums1[p1]>nums2[p2])
				nums1[p--]=nums1[p1--];
			else
				nums1[p--]=nums2[p2--];
		}
		while(p2>=0)
			nums1[p--]=nums2[p2--];
	}
	
	//这样是从前往后merge,nums1中的元素需要不断地往后移动操作。 2ms
	public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int p1=0,p2=0;
        while(p1<m && p2<n){
        	if(nums1[p1+p2]>nums2[p2]){//需要把nums2中的元素插入到p1中
        		for(int curr=p2+m;curr>p1+p2;curr--) //后面的元素整体往后挪动
        			nums1[curr]=nums1[curr-1];
        		nums1[p1+p2]=nums2[p2];
        		p2++;
        	}
        	else
        		p1++;
        }
        //需要把剩余的元素拷贝到数组nums1中
        while(p2<n){
        	nums1[p2+m]=nums2[p2];
        	p2++;
        }
    }
}
