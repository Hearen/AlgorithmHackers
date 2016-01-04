package leetcode_njz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;

public class _090_Subsets2 {
	
	//nums中会有重复元素出现
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums==null || nums.length==0)
			return null;
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		for(int i=0; i<=nums.length; i++){
			List<Integer> curStatus = new ArrayList<Integer>();
			dfs(0, i, curStatus, nums, rs);
		}
			
			
		return rs;
	}
	
	private static void dfs(int start, int count, List<Integer> curStatus, int[] nums, List<List<Integer>> rs) {
		if(curStatus.size() == count){
			rs.add(new ArrayList<Integer>(curStatus) );
			return;
		}
		
		for(int i=start; i<nums.length; i++){
			curStatus.add(nums[i]);
			dfs(i+1, count, curStatus, nums, rs);
			curStatus.remove(curStatus.size()-1);
			
			//因为有重复元素存在，同时数组已经排序-----用while循环跳过与nums[i]相同的元素
			while(i+1<nums.length && nums[i+1]==nums[i])
				i++;
		}
		
	}


	public static void main(String[] args) {
		int[] nums = {1,2,3,4,1};
		List<List<Integer>> rs = subsetsWithDup(nums);
		
		for(List<Integer> tmp : rs){
			for(int k : tmp)
				System.out.print(k+" ");
			System.out.println();
		}
	}

}
