package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年2月29日 下午9:39:21
 * @content 
 */

public class _319_Bulb_Switcher {
	
	public static void main(String args[]){
		_319_Bulb_Switcher test = new _319_Bulb_Switcher();
		int n=10000000;
		System.out.println(test.bulbSwitch(n));
		System.out.println(test.bulbSwitch_best_solution(n));
	}
	
	public int bulbSwitch_best_solution(int n){
		int count = 0;
		for(int i=1;i*i<=n;i++) count++;
		return count;
		//return Math.sqrt(n);
	}

	public int bulbSwitch(int n) {
        int count=0, res[] = new int[n+1];
        for(int step = 1; step <= n; step++){//间隔
        	for(int curr = step; curr <= n; curr+=step){
        		res[curr]^=1;
        	}
        }
        for(int i=1;i<=n;i++)
        	if(res[i]==1) count++;
        return count;
    }
}
