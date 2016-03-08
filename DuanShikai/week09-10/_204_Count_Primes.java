package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年2月29日 下午9:00:35
 * @content 
 */

public class _204_Count_Primes {
	
	public static void main(String args[]){
		_204_Count_Primes test = new _204_Count_Primes();
		int n=1;
		System.out.println(test.countPrimes_best_solution(n));
		System.out.println(test.countPrimes(n));
	}
	
	
	public int countPrimes_best_solution(int n){
		int count = 0;
		boolean nums[] = new boolean[n];
		for(int i=2;i<n;i++) nums[i]=true;
		for(int i=2;i*i<n;i++){
			if(!nums[i]) continue;
			for(int j=i;i*j<n;j++)
				nums[i*j]=false;
		}
		for(int i=0;i<n;i++)
			if(nums[i]) count++;
		return count;
	}
	
	public int countPrimes(int n) {
		int count = 0;
		for(int i=2;i<n;i++)
			if(isPrime(i)) count++;
		return count;
    }
	
	public boolean isPrime(int n){
		for(int i=2;i*i<=n;i++)
			if(n%i==0) return false;
		return true;
	}
}
