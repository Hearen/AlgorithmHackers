package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2015年12月28日 下午10:26:42
 * @content 
 */

public class _093_Restore_IP_Addresses {
	
	public static void main(String args[]){
		String s="010010";
		System.out.println(restoreIpAddresses(s));
	}
	
	public static List<String> restoreIpAddresses(String s) {
		if(s.length()>4*3) return new ArrayList<String>(); //MISTAKE注意要先考虑长度
        List<String> result=new ArrayList<String>();
        f(s,s.length(),0,0,"",result);
        return result;
    }
	
	public static void f(String s,int n,int current,int bit,String sub,List<String> result){
		if(current==n && bit==4)
			result.add(sub.substring(1));
		if(current>=n) return; //MISTAKE 注意要判断越界情况。
		int left=n-current;
		char c=s.charAt(current);
		if(left>=1) 
			f(s,n,current+1,bit+1,sub+"."+s.substring(current,current+1),result);
		if(left>=2 && c!='0') 
			f(s,n,current+2,bit+1,sub+"."+s.substring(current,current+2),result);
		if(left>=3 && c!='0' && Integer.parseInt(s.substring(current,current+3))<=255) 
			f(s,n,current+3,bit+1,sub+"."+s.substring(current,current+3),result);
		
	}
}
