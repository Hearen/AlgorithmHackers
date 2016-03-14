package com.josh.task7;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
/*
 * 问题：
 * 给定一个数组，一个上限和下限
 * 求出数组中所有在该上下限之间的数的个数
 * 注：数组中的任意数相加在上下限范围内也算
 */
public class CountOfRangeSum {
    @Test
	public void test(){  
        int[] a = {-2,5,1};  
        int i = countRangeSum(a,-2,2); 
        System.out.println(i);
    } 
    /*
     * 分析：求出数组的所有组合情况，并把每种情况加和，看是否在上下限
     */
    public int countRangeSum(int[] nums, int lower, int upper) { 
        if(null == nums || nums.length == 0)  
            return 0;  
        int[] b = new int[nums.length];  
        List<Integer> list = new ArrayList<>();
        getCombination(nums, 0, b, 0,lower,upper,list);  
        return list.size();
    }  
    //获取数组a的所有组合数。数组b中存的是a的一个组合情况
    private void getCombination(int[] a, int begin, int b[], int index,int lower,int upper,List<Integer> list) {          
        if(index >= a.length)  
            return;  
        for(int i = begin; i < a.length; i++){                
            b[index] = a[i];  
            //printArray(b,index);  
            sum(b, index,lower,upper,list);
            getCombination(a, i+1, b, index+1,lower,upper,list);  
        }  
    }
    //求b中所有元素的和
    private void sum(int[] b, int index ,int lower,int upper,List<Integer> list) {  
        int sum = 0;
        for(int i = 0; i < index+1; i++){ 
        	sum = sum + b[i];
            //System.out.print(b[i] + " ");  
        }
        //List<Integer> list = new ArrayList<>();
        if(sum>=lower && sum<=upper) list.add(sum);
        //System.out.println(sum);  
    }
//    private void printArray(int[] b, int index) {  
//              
//        for(int i = 0; i < index+1; i++){  
//            System.out.print(b[i] + " ");  
//        }  
//        System.out.println();  
//    }  
          
}
