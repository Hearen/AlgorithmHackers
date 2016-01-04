package com.xingkong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月2日 下午6:13:49 class description
 */
public class SurroundedRegions {
	public  void solve(char[][] board) {
		Queue<Integer> queue = new LinkedList<Integer>();
		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (board[i][j] == 'O' && !visited[i][j]) {
					boolean surounned = true;
					List<Integer> visitedPoints = new ArrayList<Integer>();
					queue.add(i * n + j);
					visited[i][j] = true;
					while (queue.size() > 0) {
						int point = queue.poll();
						visitedPoints.add(point);
						int x = point/n;
						int y = point%n;
						for (int k = 0; k < 4; k++) {
							int nextx = x + dir[k][0];
							int nexty = y + dir[k][1];
							if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
								if (board[nextx][nexty] == 'O' && !visited[nextx][nexty])
									queue.add(nextx * n + nexty);
								visited[nextx][nexty] = true;
							} else {
								surounned = false;
							}
						}
					}

					//如果当前遍历到的O是被包围的
					if (surounned) {
						for (int p : visitedPoints)
							board[p / n][p % n] = 'X';
					}
				}
			}
		}
		System.out.println("输出：");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
//		char[][] input = new char[][] { { 'O','X','O','O','O','O','O','O','O'}, { 'O','O','O','X', 'O', 'O', 'O', 'O' ,'X'}, { 'O','X', 'O','X', 'O','O', 'O','O','X' } ,{ 'O','O', 'O', 'O', 'X', 'O','O', 'O', 'O' }, { 'X','O', 'O','O', 'O','O','O', 'O','X' }, { 'X','X', 'O','O', 'X','O', 'X','O','X' },{ 'O','O', 'O','X', 'O','O','O', 'O','O' },{ 'O','O', 'O','X', 'O','O','O', 'O','O' },{ 'O','O', 'O','O', 'O','X','X', 'O','O' }};
		char[][] input = new char[][] { { 'X','X','X','X'}, { 'X','O','O','X' }, { 'X','X', 'O','X' } ,{ 'X','O', 'X', 'X' }};
		System.out.println("输入：");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++)
				System.out.print(input[i][j] + " ");
			System.out.println();
		}
		sr.solve(input);

	}
}
