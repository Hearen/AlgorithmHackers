package com.zyy.week1;

import java.util.Arrays;

public class ThreeSumClosest {

	public int binarySearchClosest(int[] num, int target, int start, int end){
        if(end == start + 1){
            if(target - num[start] >= num[end] - target) return end;
            else return start;
        }
        else if(end <= start) return start;
        int mid = (start + end)/2;
        if(num[mid] == target) return mid;
        else if(num[mid] < target)  return binarySearchClosest(num, target, mid, end);
        else return binarySearchClosest(num, target, start, mid);
    }

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int start = 0, end = num.length - 1;
        int sumValue = 0;
        int offset = Integer.MAX_VALUE;
        while(start < end - 1){
            int item = target - num[start]- num[end];
            int idx = binarySearchClosest(num, item, start + 1, end - 1);
            if(idx == start) idx = start+1;
            else if(idx == end) idx = end -1;
            if(num[start] + num[end] + num[idx] != target){
                int oldOfset = offset;
                offset = Math.min(offset, Math.abs(target - num[start] - num[end] - num[idx]));
                if(offset != oldOfset){
                    sumValue = num[start] + num[idx] + num[end];
                }
            }
            if(num[start] + num[end] + num[idx] > target) end--;
            else if(num[start] + num[end] + num[idx] < target) start++;
            else {sumValue = target;break;}
        }
        return sumValue;
    }

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(nums, 1));
	}

}
