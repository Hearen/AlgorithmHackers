package leetcode_njz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_Subsets1 {

	//nums中没有重复元素出现
	public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
        	return null;
        Arrays.sort(nums);
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<>();
		
        for(int i=0; i<=nums.length; i++)
        	dfs(0, i, nums, tmp, rs);
        
        return rs;
    }
	
	//在dfs中，设置寻找的长度num
	private static void dfs(int start, int num, int[] nums, List<Integer> curState, List<List<Integer>> rs) {
		if(curState.size() == num){
			rs.add(new ArrayList<>(curState));
			return;
		}
		
		for(int i=start; i<nums.length; i++){
			curState.add(nums[i]);
			dfs(i+1, num, nums, curState, rs);
			curState.remove(curState.size()-1);	
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> rs = subsets(nums);
		
		for(List<Integer> tmp : rs){
			for(int k : tmp)
				System.out.print(k+" ");
			System.out.println();
		}
			
	}

}
