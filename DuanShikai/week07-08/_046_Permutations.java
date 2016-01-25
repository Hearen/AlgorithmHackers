package com.sky.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月12日 下午12:23:31
 * @content 
 * 
 *      String[] words = {"ace", "boom", "crew", "dog", "eon"};
        List<String> wordList = Arrays.asList(words);
        
        Integer[] test = {1,2,3,4};
        List<Integer> testList = Arrays.asList(test);
 */

public class _046_Permutations {
	
	public static void main(String args[]){
		int[] nums={1,2,3};
		List<List<Integer>> result = permute(nums);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> left = new LinkedList<Integer>();
        for(int num : nums) left.add(num);
        generate(result,new ArrayList<Integer>(),left);
        return result;
    }
	
	public static void generate(List<List<Integer>> result, List<Integer> current, List<Integer> left){
		if(left.isEmpty())
			result.add(new ArrayList<Integer>(current));
		else{
			int size = left.size();
			for(int i=0;i<size;i++){//MISTAKE 注意在for循环里改变列表的大小，可能会破坏列表的结构。
				Integer num = left.get(i);
				current.add(num); left.remove(num);
				generate(result,current,left);
				current.remove(num);left.add(i,num);
			}
		}
		
	}

}
