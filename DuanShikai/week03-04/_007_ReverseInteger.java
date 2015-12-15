package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月15日 下午7:13:45
 * @content 
 */

public class _007_ReverseInteger {
	
	//TODO 整数越界后是啥？
	public static void main(String args[]){
		int x=1534236469;
		System.out.println(reverse(x));
	}
	
	/*
	 * MISTAKE 如何判断溢出？溢出后该如何处理？借鉴别人track的想法，看能否还原回来来判断是否越界。
	 * 如果 a=10*b+c 已经超出数组的最大范围，
	 * 那么(a-c)/10 !=b ? 如何推导出来？
	 */
	public static int reverse(int x) {
		int result=0;
		while(x/10 != 0 || x!=0){
			int newResult=result*10+x%10;
			//以下为正常的判断方式。
//            if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE < result*10+x%10)) {
//                return 0;
//            }
			if((newResult-x%10)/10!=result)
				return 0;
			result=newResult;
			x/=10;
		}
		return result;
    }
}
