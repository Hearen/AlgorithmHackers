package com.xingkong.exercise;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年2月24日 上午10:16:05 
* 欧几里得算法 求最大公因数
*/
public class Gcd {
	public static long gcd(long m,long n){
		//if(m<n)那么互换
		while(n!=0){
			long rem=m%n;
			m=n;
			n=rem;
		}
		return m;
	}
}
