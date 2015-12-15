package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月14日 下午11:08:45
 * @content 
 */

public class _071_SimplifyPath {
	
	public static void main(String args[]){
		String path="/a/./b/../../c/../../";
		System.out.println(simplifyPath(path));
	}
	
	public static String simplifyPath(String path) {
        String result="";int i=0;
        while(i<path.length()){
        	int start=i++; //第一个出现"/"字符的位置
        	while(i<path.length() && path.charAt(i)!='/') i++;
        	int end=i; //第二次出现字符"/"的位置
        	if(start+1==end)// "//"出现了两次
        		continue;
        	
        	else if(start+2==end && path.charAt(start+1)=='.')//两个字符之间只出现一个点，表示当前路径
        		continue;
        	
        	else if(start+3==end && path.charAt(start+1)=='.' && path.charAt(start+2)=='.'){//两个字符之间出现了两个点，表示上一级目录
        		//如何恢复到上一层目录？
        		int j=result.length()-1;
        		for(;j>0;j--){
        			if(result.charAt(j)=='/')
        				break;
        		}
        		result=result.length()==0 ? "" : result.substring(0,j);
        	}
        	else 
        		result+=path.substring(start,end);
        }
        return result.length()==0? "/" : result;
    }

}
