package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月12日 下午8:33:23
 * @content 
 */

public class _315_Count_of_Smaller_Numbers_After_Self {
	
	public static void main(String args[]){
		_315_Count_of_Smaller_Numbers_After_Self test = new _315_Count_of_Smaller_Numbers_After_Self();
		int[] nums={5,2,6,3,4,7,1};
		System.out.println(test.conutSmaller_1(nums));
		System.out.println(test.countSmaller(nums));
		System.out.println(test.countSmaller_(nums));

	}
	
	public List<Integer> conutSmaller_1(int[] nums){
		List<Integer> res = new ArrayList<>();
		int size = nums.length;
		if(size==0) return res;
		List<Integer> tmp = new ArrayList<>();
		for(int i=size-1;i>=0;i--){
			res.add(0,insertAndGet(tmp,nums[i]));
		}
		return res;
	}
	
	private Integer insertAndGet(List<Integer> tmp, int key) {
		int size = tmp.size();
		if(size==0){
			tmp.add(key); return 0;
		}
		//找到元素插入的位置
		int low = 0 , high = size-1, mid=(low+high)/2;
		if(key>tmp.get(high)){tmp.add(key); return size;}
		while(low<high){
			mid = (low+high)/2;
			if(tmp.get(mid)<key)
				low = mid+1;
			else
				high = mid;
		}int res = low;
		tmp.add(low,key);
		return res;
	}

	//二分搜索 这样原地排序需要迁移大量的元素，所以会失败。
	public List<Integer> countSmaller_(int[] nums){
		List<Integer> res = new ArrayList<>();
		int size = nums.length; 
		if(size == 0) return res;
		res.add(0);
		for(int i=size-2;i>=0;i--){
			int pos = findPos(nums,i+1,nums[i]);
			insert(nums,i,pos-1);
			res.add(0,pos-i-1);
		}
		return res;
	}
	
	//find left pos.
	public int findPos(int[] nums,int start,int key){
		int low = start, high = nums.length-1,mid=(low+high)/2;
		if(low == high && nums[low]<key) return low+1;
		if(nums[high]<key) return high+1;
		while(low<high){
			mid=(low+high)/2;
			if(nums[mid]<key)
				low=mid+1;
			else
				high=mid;
		}
		return low;
	}
	//insert val
	public void insert(int[] nums,int from,int to){
		int temp = nums[from];
		for(int i=from; i<to; i++)
			nums[i]=nums[i+1];
		nums[to]=temp;
	}
	
	//暴力破解
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int size = nums.length;
		for(int i=0;i<size-1;i++){
			int counter=0;
			for(int j=i+1;j<size;j++){
				if(nums[i]>nums[j]) counter++;
			}
			res.add(counter);
		}
		res.add(0);
		return res;
	}
}
