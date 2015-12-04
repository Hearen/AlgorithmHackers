package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2015年12月4日 下午4:14:25 
* 难度：Hard
*/
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums.length==0)
			return -1;
        int start=0;
        int end=nums.length-1;
        int mid=(nums.length-1)/2;
        return findTarget(nums,target,start,mid,end);
    }
	public int findTarget(int[] nums,int t,int left,int mid,int right){
		if(left>=right&&t!=nums[left]){
			return -1;
		}
		if(t==nums[left])
			return left;
		if(t==nums[mid])
			return mid;
		if(t==nums[right])
			return right;
		if(nums[left]<nums[mid]){
			if(nums[left]<t && t <nums[mid]){
				return findTarget(nums,t,left+1,(left+mid)/2,mid-1);
			}
			else{
				return findTarget(nums,t,mid+1,(mid+right)/2,right-1);
			}
		}else{
			if(t>nums[left]){
				return findTarget(nums,t,left+1,(left+mid)/2,mid-1);
			}else{
				if(t<nums[mid]){
					return findTarget(nums,t,left+1,(left+mid)/2,mid-1);
				}else{
					return findTarget(nums,t,mid+1,(mid+right)/2,right-1);
				}
			}
		}
	}
	public static void main(String args[]){
		SearchInRotatedSortedArray si=new SearchInRotatedSortedArray();
		int[] test=new int[]{4,5,6,6,7,8,1,2,3};
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]+"位置:"+si.search(test,test[i]));
		}
		System.out.println(si.search(new int[]{1},9));
	}
}
