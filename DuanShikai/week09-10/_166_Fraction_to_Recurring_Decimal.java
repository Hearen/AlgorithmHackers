package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DuanSky
 * @date 2016年3月3日 上午10:59:10
 * @content
 * -1
-2147483648 
 */

public class _166_Fraction_to_Recurring_Decimal {
	
	public static void main(String args[]){
		int numerator =0;
		int denominator = 3;
		_166_Fraction_to_Recurring_Decimal test = new _166_Fraction_to_Recurring_Decimal();
		System.out.println(test.fractionToDecimal(numerator, denominator));
		System.out.println((double)numerator/denominator);
	}
	
	
	
	private String fractionToDecimal(int numerator, int denominator) {
		if(numerator==0) return "0"; //MISTAKE 注意考察 0 的情况！！
		boolean flag =( (numerator>0) ^ (denominator>0) )  ? false : true; //MISTAKE 注意需要考虑符号问题！！
		long nume = Math.abs((long)numerator), deno = Math.abs((long)denominator); //MISTAKE 注意最小负数的绝对值是要大于最大正数的绝对值，所以可能造成溢出！！！
		if(nume%deno==0) return (flag ? "" : "-") + nume/deno;
        //head
		long head = nume / deno;
		String res = (flag ? "" : "-") +head +".";
		nume = nume - head * deno;
		Map<Long,Integer> map = new HashMap<>();
		while(!map.containsKey(nume)){
			map.put(nume, res.length());
			if(nume*10<deno){
				map.put(nume, res.length());
				nume*=10;
				res+="0";
				continue;
			}
			nume*=10;
			if(nume%deno==0) return res+(nume/deno)+"";
			
			res += (nume/deno+"");
			nume -= nume/deno * deno;

		}
		
		return res.substring(0,map.get(nume))+"("+res.substring(map.get(nume))+")";
	}



	//wrong answer!
	public String fractionToDecimal_(int numerator, int denominator) {
		if(numerator == 0) return "0";
		if(numerator%denominator==0) return numerator/denominator+"";
        //head
		int head = numerator / denominator;
		String res = head +".";
		numerator -= head * denominator;
		Map<Integer,Integer> map = new HashMap<>();
		int zeroNum = 0;
		while(numerator<denominator){
			numerator*=10;
			zeroNum++;
		}
		for(int i=1;i<zeroNum;i++)
			res+="0";
		while(!map.containsKey(numerator)){
			map.put(numerator, res.length());
			res+=numerator/denominator;
			numerator %= denominator;
			if(numerator==0) return res;
			zeroNum = 0;
			while(numerator<denominator){
				numerator*=10;
				zeroNum++;
			}

		}
		return res.substring(0,map.get(numerator))+"("+res.substring(map.get(numerator))+")";
    }
}
