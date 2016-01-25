package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月12日 下午1:08:51
 * @content 
 */

public class _047_Permutations_II {
	
	public static void main(String args[]){
		int[] nums={0,0,1,1};
		List<List<Integer>> result = permuteUnique(nums);
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        List<Integer> left = new LinkedList<Integer>();
        Arrays.sort(nums);
        for(int num : nums) left.add(num);
        generate(result,new ArrayList<Integer>(),left);
        return result;
    }
	
	public static void generate(List<List<Integer>> result, List<Integer> current, List<Integer> left){
		if(left.isEmpty())
			result.add(new ArrayList<Integer>(current));
		else{
			int size = left.size(); Integer last = left.get(0)+1; //MISTAKE 注意这里不能通过简单的取反，因为0本身就是0的相反数o(╯□╰)o。
			for(int i=0;i<size;i++){//MISTAKE 注意在for循环里改变列表的大小，可能会破坏列表的结构。
				Integer num = left.get(i);
				if(num.equals(last)) continue;
				last = num;
				current.add(num); left.remove(num);
				generate(result,current,left);
				current.remove(current.size()-1);left.add(i,num);//MISTAKE 注意移除的时候需要在最后一位移除。
			}
		}
	}
}
