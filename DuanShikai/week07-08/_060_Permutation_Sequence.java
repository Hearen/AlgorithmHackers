package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月12日 下午3:26:11
 * @content 
 */

public class _060_Permutation_Sequence {
	
	public static void main(String args[]){
		int n=4; int k=5;
        _060_Permutation_Sequence test = new _060_Permutation_Sequence();
        for(int i=1;i<=test.getFactorial(n);i++)
        	System.out.println(test.getPermutation(n, i));
        System.out.println("=======");
        System.out.println(test.getPermutation(n, k));
	}
	
	public String getPermutation(int n, int k) {
        String result="";
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++) list.add(i);
        result = generate(result,list,k);
        return result;
    }
	
	private String generate(String s,List<Integer> left, int k){
		if(left.isEmpty()) return s;
		if(left.size()==1) {
			s+=left.get(0)+"";
			return s;
		}
		int size=getFactorial(left.size()-1), m=k%size, n=k/size;
		if(m==0){//刚好被整除，说明是以n元素开头的最后一个元素。
			s+=left.get(n-1); left.remove(n-1);
			String temp="";
			for(Integer num : left)
				temp=num+temp;
			s+=temp;
			return s;
		}
		else{//如果没有被整除，说明有余数，即用完了前面n个元素，那么该元素是以n+1开头的。
			s+=left.get(n);left.remove(n);
			return generate(s,left,k-n*size);
		}
	}
	
	private int getFactorial(int n){
		int res=1;
		for(int i=1;i<=n;i++)
			res*=i;
		return res;
	}

}
