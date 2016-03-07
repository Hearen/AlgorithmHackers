package week8;

import java.util.ArrayList;
import java.util.LinkedList;

public class UglyNumber263 {
    /**
     * @param num
     * @return
     * @author xpxstar@gmail.com
     * @2016年1月21日
     * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
     */
    public boolean isUgly(int num) {
    	if(num == 0)
    		return false;
        while (num%2 ==0) {
			num = num>>1;
		}
        while (num%3 ==0) {
			num = num/3;
		}
        while (num%5 == 0) {
			num = num/5;
		}
        return num == 1;
    }
    /**
     * @param n
     * @return
     * @author xpxstar@gmail.com
     * @2016年1月25日
     * return the n-th ugly number which 1 is the first one
     */
    public int uglyII(int n) {
    	if (n<2) {
			return 1;
		}
    	ArrayList<LinkedList<Integer>> ll = new ArrayList<>(3);
    	for (int i = 0; i < 3; i++) {
			ll.add(new LinkedList<Integer>());
		}
    	int result = 1,index;
    	for (int i = 1; i < n; i++) {
    		ll.get(0).add(result*2);
    		ll.get(1).add(result*3);
    		ll.get(2).add(result*5);
    		index = 0;
    		if (i == 38) {
				System.out.println(' ');
			}
			for (int j = 1; j < 3; j++) {
				if (ll.get(index).getFirst() >= ll.get(j).getFirst()) {
					if (ll.get(index).getFirst().equals(ll.get(j).getFirst())) {
						ll.get(index).removeFirst();
					}
					index = j;
				}
			}
			result = ll.get(index).removeFirst();
			System.out.println(result);
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber263 un = new UglyNumber263();
		System.out.println(un.uglyII(40));
	}

}
