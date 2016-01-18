package week7;

import java.util.HashMap;
import java.util.Map;

public class BestTimeTradeStock121 {
	
	/**
	 * @param prices
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月14日
	 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
	 */
	public int maxProfitI(int[] prices) {
		if (prices.length<2) {
			return 0;
		}
        int min = prices[0],profit = 0,tmp;
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}else {
				tmp = prices[i]-min;
				profit = tmp>profit?tmp:profit;
			}
		}
		return profit;
    }
	/**
	 * @param prices
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月14日
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).	 
注意，手里的股票不能多于1个。*/
	public int maxProfitII(int[] prices) {
		if (prices.length<2) {
			return 0;
		}
        int min = prices[0],smin = prices[0],profit = 0,sprofit = 0,tmp;
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}else {
				tmp = prices[i]-min;
				if(tmp>profit){
					sprofit = profit;
					profit = tmp;
				}
			}
		}
		return profit;
    }
	/**
	 * @param prices
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月14日
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
	 */
	public int maxProfitIII(int[] prices) {
		int total = 0;
        for (int i=prices.length-1; i >  0; i++) {
        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }
	public static void main(String[] args){
		BestTimeTradeStock121 bt = new BestTimeTradeStock121();
		int[] p = {4,2,8,1,5,6};
		System.out.println(bt.maxProfitII(p));
	}
}
