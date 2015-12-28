package com.cz.algorithm.four;

public class SqrtX {

	public static void main(String[] args) {
		int x = 10;
		System.out.println(new SqrtX().mySqrt(x));
	}
	public int mySqrt(int x) {
        if(x < 0) return 0;
		return (int)Math.sqrt(x);
	}
}
