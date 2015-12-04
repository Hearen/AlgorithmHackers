package com.zyy.week1;

public class WordSearch {

	public boolean isExist(char[][] board, char[] words, int y, int x, int i) {
		if (i == words.length)
			return true;
		if (y < 0 || x < 0 || y == board.length || x == board[y].length)
			return false;
		if ((board[y][x] != words[i]))
			return false;
		board[y][x] ^= 256;
		boolean exist = isExist(board, words, y, x + 1, i + 1)
				|| isExist(board, words, y + 1, x, i + 1)
				|| isExist(board, words, y, x - 1, i + 1)
				|| isExist(board, words, y - 1, x, i + 1);
		board[y][x] ^= 256;
		return exist;

	}

	// 回溯
	public boolean exist(char[][] board, String word) {
		// 存放word单个字母
		char[] words = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (isExist(board, words, i, j, 0))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board, "ABGGGG"));

	}
}
