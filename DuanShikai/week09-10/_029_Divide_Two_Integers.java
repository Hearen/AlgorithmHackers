package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月2日 下午5:30:42
 * @content 
 */

public class _029_Divide_Two_Integers {
	
	public static void main(String args[]){
		_029_Divide_Two_Integers test = new _029_Divide_Two_Integers();
		//System.out.println(Integer.MAX_VALUE +":"+ Integer.MIN_VALUE);
		int dividend = Integer.MIN_VALUE;
		int divisor = -1;
		System.out.println(test.divide(dividend, divisor));
	}
	
	public int divide(int dividend, int divisor) {
        if(divisor == 0 ||(dividend == Integer.MIN_VALUE && divisor==-1))
        	return Integer.MAX_VALUE;
        int sign = ((dividend<0) ^ (divisor<0)) == true ? -1 : 1 ;
        //MISTAKE 注意，这里需要将其转换成long类型
        long divd = Math.abs((long)dividend), divr = Math.abs((long)divisor);
        if(divd<divr) return 0;
        int res = 0;
        while(divr<<res <= divd) 
        	res++;
        int f = (1<<(res-1)) +  divide((int)(divd-(divr<<(res-1))),(int)divr);
        return sign == 1 ? f : -f;
    }

}
