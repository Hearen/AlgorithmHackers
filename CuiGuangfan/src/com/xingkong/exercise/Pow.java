package com.xingkong.exercise;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年2月24日 上午10:20:03 
* 幂运算
*/
public class Pow {
	public static long pow(long x,int n){
		if(n==0)
			return 1;
		if(n==1)
			return x;
		if(n%2==0)//如果n是偶数
			return  pow(x*x,n/2);
		else//如果n是奇数
			return pow(x*x,n/2)*x;
	}
}
