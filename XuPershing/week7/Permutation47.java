package week7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Generated;

/**
 * @author xpxstar@gmail.com
 *
 * 2016年1月13日
 */
public class Permutation47 {
	
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月13日
	 * Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	List<List<Integer>> result = new LinkedList();
	public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
			List tmp = 
		}
    }
	private void findNext(int[] nums,int[] store,int level){
		if (level == nums.length) {
			return;
		}
		
		for (int i = 0;i<nums.length;i++) {
			if(!avalible[i]){
				tmp.add(nums[i]);
			}
		}
		for (int i = 0;i<nums.length;i++) {
			if(avalible[i]){
				tmp.add(nums[i]);
			}
		}
	}
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月13日
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
