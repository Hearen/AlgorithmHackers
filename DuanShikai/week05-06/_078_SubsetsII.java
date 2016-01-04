/**
* @author DuanSky
* @date 2015��10��11�� ����3:56:15
* @content 
*/
package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _078_SubsetsII {
	
	public static void main(String args[]){
		int[] nums={1,2,2};
		System.out.println(subsetsWithDup(nums));
	}
	
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0) return result;
        Arrays.sort(nums); 
        result.add(new ArrayList<Integer>()); //增加空集
        for(int i=0;i<nums.length;){
        	int count=0; //统计有多少个重复的元素
        	//TRICK 这里采用这样的方式来统计相同元素出现的数目，确实不错
        	while(i+count<nums.length && nums[i+count]==nums[i]) count++;
    		int size=result.size();//MISTAKE 注意这里需要将这行代码提到两个for外面，之前放在里面是错误的。
        	for(int k=1;k<=count;k++){//相同的元素出现了k次
        		for(int j=0;j<size;j++){
        			List<Integer> adding = new ArrayList<Integer>(result.get(j));
        			for(int t=0;t<k;t++)//将k个该元素添加到队列中
        				adding.add(nums[i]);
        			result.add(adding);
        		}
        	}
        	i+=count;
        }
        return result;
    }
	
	public static List<List<Integer>> _subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        //rebuild input number.
        List<List<Integer>> input=new ArrayList<List<Integer>>();
        for(int num : nums){
        	boolean find=false;
        	for(List<Integer> list : input){
        		if(list.get(0)==num){
        			list.add(num);
        			find=true;
        		}
        	}
        	if(find==false){
        		List<Integer> temp=new ArrayList<Integer>();
        		temp.add(num);
        	}
        }
        //
        int count=input.size();
        for(int i=1;i<Math.pow(2, count);i++){
        	int k=0;int t=i;
        	
        	while(t!=0){
        		if((t&1)==1){
        			List<Integer> list=new ArrayList<Integer>();
        			list.add(nums[k]);
        		}
        	}
        }
        return result;
    }
}
