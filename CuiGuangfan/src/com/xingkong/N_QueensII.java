package com.xingkong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2015年12月29日 下午10:46:16 class description
 */
public class N_QueensII {
	public int count = 0;
	public void backTrace(int[] rowFlag, int[] columnFlag, int[] occupyPlace, int currentDepth) {
		if (currentDepth == rowFlag.length) {
			count++;
			return;
		}
		if (rowFlag[currentDepth] == 1)
			return;
		for (int j = 0; j < columnFlag.length; j++) {
			if (columnFlag[j] == 1)
				continue;
			rowFlag[currentDepth] = 1;
			columnFlag[j] = 1;
			occupyPlace[currentDepth] = j;
			if (!judgeSlash(occupyPlace, currentDepth))
				backTrace(rowFlag, columnFlag, occupyPlace, currentDepth + 1);
			rowFlag[currentDepth] = 0;
			columnFlag[j] = 0;
			occupyPlace[currentDepth] = 0;
		}
	}

	public boolean judgeSlash(int[] columnFlag, int currentDepth) {
		for(int i=0;i<currentDepth;i++){
			if (Math.abs(columnFlag[i] - columnFlag[currentDepth]) == Math.abs(i-currentDepth))
				return true;
		}
		
		return false;
	}

	public int totalNQueens(int n) {
		int[] rowFlag = new int[n];
		int[] columnFlag = new int[n];
		int[] occupyPlace = new int[n];
		backTrace(rowFlag, columnFlag, occupyPlace, 0);
		return this.count;
	}

	public static void main(String[] args) {
		N_QueensII nq = new N_QueensII();
		System.out.println(nq.totalNQueens(6));
	}
}
