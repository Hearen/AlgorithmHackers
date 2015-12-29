package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月22日 下午7:27:32
 * @content 
 */

public class _050_Pow_x_n_2 {
	
	public static void main(String args[]){
		double x=10;
		int n=21;
		System.out.println(myPow(x,n));
	}
	
	public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
        	n=-n;
        	x=1/x;
        }
        return n%2==0 ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }

}
