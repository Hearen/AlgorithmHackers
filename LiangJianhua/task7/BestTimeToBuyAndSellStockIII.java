package com.josh.task7;

import org.junit.Test;
/*
 * 问题：
 * 数组中存储的事第i天的股票价格
 * 求最佳股票交易时间
 * 注：一次买入和一次卖出为一次交易
 */
public class BestTimeToBuyAndSellStockIII {
	@Test
	public void test(){
		int[] prices={3,2,6,5,0,3};
		System.out.println(maxProfit3(prices));
 	}
	/*
	 *要求：只进行一次交易，求最大获利
	 *     即求数组中的最大值和最小值，且最小值要在最大值前面
	 */
    public int maxProfit1(int[] prices) {
    	if(prices.length <= 1) return 0;
		int minPrice = prices[0],maxPrice=prices[0],minPrice2 = prices[0];
		for(int i=0;i<prices.length;i++){
			if(prices[i]>maxPrice || prices[i]-minPrice2>maxPrice-minPrice){
				minPrice = minPrice2;
				maxPrice = prices[i];
			}
			if(prices[i]<minPrice2){
				minPrice2 = prices[i];
			}
		}
    	return maxPrice-minPrice; 
    }
    /*
     * 不限制交易次数，求最大获利
     * 即：贪心算法，从前到后，只要有收益（前一天比后一天价格低）就进行一次交易，然后把所有获利相加
     */
    public int maxProfit2(int[] prices) {
    	if(prices.length < 2) return 0;
    	int minPrice = prices[0],maxPrice=prices[0],maxProfit = 0,i=0;
		while(i<prices.length-1){
			if(prices[i]<prices[i+1]){
				minPrice = prices[i];
				while(i<prices.length-1 && prices[i]<prices[i+1]){
					i++;
				}
				maxPrice = prices[i];
				maxProfit = maxProfit + (maxPrice - minPrice);
			}
			i++;
		}
		return maxProfit;
    }
    /*
     * 最多进行两次交易，求最大获利
     * 即：从前向后遍历一次，求出截止第i天，之前的最大收益，求法同问题1
     *    从后向前遍历一次，求从第i天开始，之后的最大收益，求法同问题1
     *    然后一次遍历两个数组求出最大收益
     */
    public int maxProfit3(int[] prices) {
    	if(prices.length < 2) return 0;
        int[] preProfit = new int[prices.length];
        int[] postProfit= new int[prices.length];
        int curMin = prices[0],curMax=prices[prices.length-1], maxProfit=0;
        for(int i=0;i<prices.length;i++){//顺着遍历截止到第i天的最大收益
        	curMin = Math.min(curMin, prices[i]);
        	maxProfit = Math.max(maxProfit, prices[i]-curMin);
        	preProfit[i] = maxProfit;
        }
        maxProfit = 0;
        for(int j=prices.length-1;j>=0;j--){//逆着遍历第i天之后的最大收益
        	curMax = Math.max(curMax, prices[j]);
        	maxProfit = Math.max(maxProfit, curMax-prices[j]);
        	postProfit[j] = maxProfit;
        }
        maxProfit = preProfit[0]+postProfit[0];
        for(int k=0;k<prices.length;k++){
        	if(preProfit[k]+postProfit[k]>maxProfit){
        		maxProfit = preProfit[k]+postProfit[k];
        	}
        }
    	return maxProfit;
    }
}
