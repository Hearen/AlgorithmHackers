package com.zyy.week4;

public class MySqrt {

	public int sqrt(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}

	public int mySqrt(int x) {
		// 使用二分查找
		if (x == 0) {
			return 0;
		}
		int begin = 1, end = x;
		while (true) {
			int mid = (begin + end) / 2;
//			int mid = begin + (end - begin) / 2;
			if (mid <= x / mid) {
				if (mid + 1 > x / (mid + 1))
					return mid;
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}

	public static void main(String[] args) {
		MySqrt sqrt = new MySqrt();
		System.out.println(sqrt.mySqrt(16));
		System.out.println(sqrt.mySqrt(80));
		System.out.println(sqrt.mySqrt(2147395599));

	}
}
