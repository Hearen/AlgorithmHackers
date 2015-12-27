package com.zyy.week4;

public class MyPow {
	// 求x的n次方，其中n是整数
	// 超时
	public double myPow1(double x, int n) {
		boolean flag = n >= 0 ? true : false;
		int index = n > 0 ? n : -n;
		double result = 1.0;
		while (index-- > 0) {
			result *= x;
		}
		if (flag)
			return result;
		return 1 / result;
	}

	// 使用二分法
	public double myPow2(double x, int n) {
		boolean flag = n >= 0 ? true : false;
		n = n / 2 == 0 ? n : n + 1;
		double result = 1.0;
//		result = powpow(x,n);
		if (flag)
			return result;
		return 1 / result;
	}
	

	public static void main(String[] args) {
		MyPow mp = new MyPow();
		System.out.println(mp.myPow1(5, -3));
	}
}
