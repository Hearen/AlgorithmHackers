package com.xingkong;

import java.util.HashMap;
import java.util.Map;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月3日 下午2:24:34 
* class description
* 没有解决
*/
public class N_166_Fraction_to_Recurring_Decimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
        if (denominator == 0) return "";
        
        String ans = "";
        
        //如果结果为负数
        if ((numerator < 0) ^ (denominator < 0)) {
            ans += "-";
        }
        
        //下面要把两个数都转为正数，为避免溢出，int转为long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        //结果的整数部分
        long res = num / den;
        ans += String.valueOf(res);
        
        //如果能够整除，返回结果
        long rem = (num % den) * 10;
        if (rem == 0) return ans;
        
        //结果的小数部分
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        ans += ".";
        while (rem != 0) {
            //如果前面已经出现过该余数，那么将会开始循环
            if (map.containsKey(rem)) {
                int beg = map.get(rem); //循环体开始的位置
                String part1 = ans.substring(0, beg);
                String part2 = ans.substring(beg, ans.length());
                ans = part1 + "(" + part2 + ")";
                return ans;
            }
            
            //继续往下除
            map.put(rem, ans.length());
            res = rem / den;
            ans += String.valueOf(res);
            rem = (rem % den) * 10;
        }
        
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_166_Fraction_to_Recurring_Decimal.fractionToDecimal(1, 99));
		//System.out.println(1*1.0/90);
	}

}
