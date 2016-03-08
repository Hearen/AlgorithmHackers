package com.zyy.week9;

/**
 * 
 * @author ZYY 统计小于非负整数n的素数的数目 素数：除了1和它本身不能被其他数整除
 *
 */
public class _204_CountPrimes {
	// 超时
	public int countPrimes(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (isPrimes(i))
				result++;
		}
		return result;
	}

	// 判断是不是素数
	private boolean isPrimes(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		int edge = (int) Math.sqrt(n);
		for (int i = 2; i <= edge; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// Sieve of Eratosthenes:找质数的算法
	//40ms 24%
	public int countPrimes1(int n) {
		// 使用一个长度为n的数组记录每个数的状态
		boolean[] primes = new boolean[n];
		// 初始化数组primes
		for (int i = 2; i < n; i++) {
			primes[i] = true;
		}
		// 按照倍数方式将数组中的合数置为false
		for (int i = 2; i * i < n; i++) {
			if (!primes[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				primes[j] = false;
			}
		}
		// 统计素数个数
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
		return count;
	}

	// Sieve of Eratosthenes:找质数的算法
	// 32ms(43%)
	public int countPrimes2(int n) {
		// 使用一个长度为n的数组记录每个数的状态
		boolean[] primes = new boolean[n];
		// 初始化数组primes
		for (int i = 2; i < n; i++) {
			primes[i] = true;
		}
		// 统计素数个数
		int count = 0;
		// 按照倍数方式将数组中的合数置为false
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				count++;
				for (int j = 2; i * j < n; j++) {
					primes[i * j] = false;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		_204_CountPrimes cp = new _204_CountPrimes();
		System.out.println(cp.countPrimes2(1500));
	}
}
