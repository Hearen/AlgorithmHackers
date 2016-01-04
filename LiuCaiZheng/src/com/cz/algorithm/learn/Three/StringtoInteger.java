package com.cz.algorithm.learn.Three;

public class StringtoInteger {
	public static void main(String[] args) {
		String s = "8454654";
		System.out.println(new StringtoInteger().myAtoi(s));
	}
     /**
      *  because the if the string is larger than the Integer.MAX_VALUE or smaller than the Integer.MIN_VALUE, the number should change 
      *     to the  Integer.MAX_VALUE or  Integer.MIN_VALUE, as for the change processing will be over flow the Integer.MAX_VALUE and 
      *     Integer.MIN_VAULE.
      *     as I have obtained from the demo . the 
      *                      Integer.MAX_VALUE                  2147483647
      *                      Integer.MIN_VALUE                -2147483648 
      *            also the   Integer.MAX_VALUE  + 1 ==  Integer.MIN_VALUE   and   Integer.MIN_VALUE - 1 = = Integer.MAX_VALUE 
      *    on the other hand, how to change int to long that how to fill the higher 32bit. inversely, how to change long to int and how to tackle 
      *         the higher 32bit.
      *     
      *     
      * 
      * 
      * 
      * 
      * */
	public int myAtoi(String str) {
		if (str == null || str.trim().length() < 1)
			return 0;
		str = str.trim();
		int len = str.length();
		boolean flag = true;
		int i = 0;
		double  result = 0;
		if (str.charAt(0) == '+') {
			i++;
		} else if (str.charAt(0) == '-') {
			flag = false;
			i++;
		}
		while (i < len) {
		    if ((str.charAt(i) >=  '0') && (str.charAt(i)  <=  '9' )) {
				result = str.charAt(i) - '0' + result * 10;
				i ++;
			} else {
				break;
			}
		}
		if (!flag) {
			result = -result;
		}
		if (result > Integer.MAX_VALUE  -1 ) {
			return  Integer.MAX_VALUE;
		} else if (result < Integer.MIN_VALUE + 1) {
			return  Integer.MIN_VALUE;
		}
		return (int)result;
	}
}
