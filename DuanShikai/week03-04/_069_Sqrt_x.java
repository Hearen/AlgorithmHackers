package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月22日 下午6:16:44
 * @content 
 */

public class _069_Sqrt_x_ {
	
	public static void main(String args[]){
		int x=2147395599;
		System.out.println(mySqrt(x));
	}
	public static int mySqrt(int x) {
		if(x==1) return 1;
		int low=0; int high=x; int middle=0; long current=0;
		while(low<=high){
			middle=(high-low)/2+low;
			//MISTAKE 如果middle比较大，两个数的乘积超过了整数能够表示的范围？
			current = middle * middle;
			if(current == x || middle == low)
				return middle;
			else if(current/middle != middle || current > x)
				high=middle;
			else
				low=middle;
		}
		return low;
	}
}
