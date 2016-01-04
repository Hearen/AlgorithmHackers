package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DuanSky
 * @date 2015年12月29日 下午5:20:31
 * @content 
 */

public class _051_N_Queens {
	
	public static void main(String args[]){
		//System.out.println(soluNums(5));
		System.out.println(solveNQueens(5));
	}
	
	public static int soluNums(int n){
		List<Integer> list=new ArrayList<Integer>();
		List<List<Integer>> result=new ArrayList<>();
		calculate(1,n,list,result);
		return result.size();
	}
	
	public static void calculate(int current,int n,List<Integer> list,List<List<Integer>> result){
		if(current>n) {
			result.add(list);
			return;
		}
		List<Integer> legalPos=getLegalPos(n,list);
		for(int pos : legalPos){
			List<Integer> temp=new ArrayList<Integer>(list);
			temp.add(pos);
			calculate(current+1,n,temp,result);
		}
	}
	
	public static List<Integer> getLegalPos(int n,List<Integer> list){
		int[] result=new int[n];
		for(int i=0;i<n;i++) result[i]=1;
		if(list==null || list.size()==0) return arrayToList(result); //如果这是下入的第一个Queen，可供选择的位置很多。
		int size=list.size(); int current=size+1;
		if(size>=n) return arrayToList(result); //如果已经全部下完，则没有可供选择的位置。
		for(int i=1;i<=size;i++){
			int right=list.get(i-1)+current-i;
			if(right<=n) result[right-1]=0;
			int left=list.get(i-1)-(current-i);
			if(left>=1) result[left-1]=0;
			result[list.get(i-1)-1]=0;
		}
		return arrayToList(result);
	}
	
	public static List<Integer> arrayToList(int[] array){
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<array.length;i++)
			if(array[i]==1) result.add(i+1);
		return result;
	}
	
	public static List<List<String>> solveNQueens(int n) {
		List<Integer> list=new ArrayList<Integer>();
		List<List<Integer>> result=new ArrayList<>();
		calculate(1,n,list,result);
		return getSolution(result);
    } 
	
	public static List<List<String>> getSolution(List<List<Integer>> list){
		List<List<String>> result=new ArrayList<>();
		for(List<Integer> single : list){
			result.add(getSingle(single));
		}
		return result;
	}
	
	public static List<String> getSingle(List<Integer> list){
		List<String> result=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			String single="";
			for(int j=1;j<=list.size();j++){
				if(j==list.get(i)) single+="Q";
				else single+=".";
			}
			result.add(single);
		}
		return result;
	}
}
