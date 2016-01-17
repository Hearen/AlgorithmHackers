package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	//46. Permutations
	public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> res = new  ArrayList<List<Integer>>();
		 recursive(res, nums, 0, nums.length);
		 return res;
	}

	void recursive(List<List<Integer>> res, int[] nums, int begin, int end) {
		if (end == begin) {
			List<Integer> li = new ArrayList<Integer>(nums.length);
			for(Integer num:nums){
				li.add(num);
			}
			res.add(li);
		} else {
			for (int i = begin; i < end; i++) {
				swap(nums, begin, i);
				recursive(res, nums, begin + 1, end);
				swap(nums, i, begin);
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	//47.  Permutations II
}
