package leetcode_njz;

import java.util.HashMap;

public class _001_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        	return null;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
        	int temp1 = nums[i];
        	if(!map.containsKey(temp1)){
        		map.put(target - temp1, i);
        	}else{
        		result[0] = map.get(temp1) + 1;
        		result[1] = i + 1;
        		break;
        	}
        }
        return result;
    }
    
    public static void main(String[] args){
    	int[] a = {2,7,11,15};
    	int[] rs = twoSum(a,9);
    	System.out.println(rs[0]+" "+rs[1]);
    }
}//end class