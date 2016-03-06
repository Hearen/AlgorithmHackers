package com.zyy.week9;

/**
 * 
 * @author ZYY 计算两个数的乘积，用字符串表示，且两个数可以任意大
 *
 */
public class _43_MultiplyStrings {
	//9ms 72.73%
	public String multiply(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();
		int[] pos = new int[n1 + n2];
		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int po1 = i + j, po2 = i + j + 1;
				int num = multi + pos[po2];
				// 十位
				pos[po1] += num / 10;
				// 个位
				pos[po2] = num % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int k : pos) {
			if (!(sb.length() == 0 && k == 0))
				sb.append(k);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
