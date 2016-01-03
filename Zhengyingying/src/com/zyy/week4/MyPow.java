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
	// 超时
	public double myPow2(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n == -1)
			return 1 / x;
		boolean flag = n >= 0 ? true : false;
		n = n >= 0 ? n : -n;
		double result = 1.0;
		int mid = n / 2;
		result = powpow(x, mid) * powpow(x, n - mid);
		if (flag)
			return result;
		return 1 / result;
	}

	public double powpow(double x, int mid) {
		if (mid == 1)
			return x;
		return powpow(x, mid / 2) * powpow(x, mid - mid / 2);
	}

	//为什么我想不到？？？
	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
	}

	public static void main(String[] args) {
		MyPow mp = new MyPow();
		// System.out.println(mp.myPow1(5, -3));
		System.out.println(mp.pow(0.00001, 2147483647));
		// System.out.println(mp.myPow2(34.00515, -3));
		// System.out.println(mp.myPow2(8.95371, -1));
	}
}
