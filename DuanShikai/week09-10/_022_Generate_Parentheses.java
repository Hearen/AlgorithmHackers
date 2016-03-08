package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年2月29日 下午8:39:46
 * @content 
 */

public class _022_Generate_Parentheses {
	
	public static void main(String args[]){
		_022_Generate_Parentheses test = new _022_Generate_Parentheses();
		List<String> res = test.generateParenthesis(2);
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String s="";
        solve(0,0,n,s,result);
        return result;
    }
	
	public void solve(int left,int right,int n,String s,List<String> result){
		if(left == right && right == n) result.add(s);//左边的括号和右边的括号都已经用完，而且达到指定数目，程序可以输出了。
		if(left >= right){//左边的括号数目多于或等于右边的元素数目
			if(left<=n) solve(left+1,right,n,s+"(",result);
			if(right<=n) solve(left,right+1,n,s+")",result);
		}
	}
}
