package com.xpx.demo;

public class WordSearch {
	char[][] board ={
		{'A','B','C','E'},
	  	{'S','F','E','S'},
		{'A','D','E','E'}
	};
	/**
	 * @param board
	 * @param word
	 * @return
	 * @author xpxstar@gmail.com
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * The word can be constructed from letters of sequentially adjacent cell, 
	 * where "adjacent" cells are those horizontally or vertically neighboring. 
	 * The same letter cell may not be used more than once.
	 * For example,
	 * Given board =
	 * [
	 *   ['A','B','C','E'],
	 *   ['S','F','C','S'],
	 *   ['A','D','E','E']
	 * ]
	 * word = "ABCCED", -> returns true,
	 * word = "SEE", -> returns true,
	 * word = "ABCB", -> returns false.
	 */
	public boolean exist(char[][] board,String word) {
	/*思路 首先要找到起始点，从起始点开始搜索
	 * 标记该节点为已匹配，依次访问上右下左边的点是否有被搜索词的下一个字符
	 * 如果是继续以该节点为起始搜索剩下的节点
	 * 如果不是，则返回false，并将该节点访问标记抹除。
	 * 如果该起点没有找到对应词，那么寻找下一个起点，直到找到词，返回true或者遍历完所有起点。
	 */
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j]== word.charAt(0)) {
					boolean[][] mark = new boolean[board.length][board[0].length];
						int tmp_x = i,tmp_y = j;
						boolean r0 = visit(board, mark, tmp_x, tmp_y,0, word, 1);
						boolean r1 = visit(board, mark, tmp_x, tmp_y,1, word, 1);
						boolean r2 = visit(board, mark, tmp_x, tmp_y,2, word, 1);
						boolean r3 = visit(board, mark, tmp_x, tmp_y,3, word, 1);
						if (r0||r1||r2||r3) {
							return true;
						}	
				}
			}
		}
	return false;
	}
	/**
	 * @param board 词表
	 * @param mark 已匹配词标记
	 * @param x 被访问节点纵坐标
	 * @param y 被访问节点横坐标
	 * @param direction 方向，0-上，1-右，2-下，3-左
	 * @param word 目标词
	 * @param index 当前匹配进度
	 * @return 该方向是否匹配完成
	 * @author xpxstar@gmail.com
	 */
	private boolean visit(char[][] board,boolean[][] mark,int x,int y,int direction,String word,int index){
		/*思路，首先标记当前词被访问
		 * 判断是否匹配完成
		 * 注意判断是否越界
		 * 如果当前词匹配成功，继续匹配，否则返回false并清除访问标记
		 */
		mark[x][y] = true;
		if (index == word.length()) {
			return true;
		}
		int next_x =0,next_y = 0;
		boolean result = false;
		boolean inarea = false;
		switch (direction) {
		case 0:
			next_x = x-1;
			next_y = y;
			inarea = (next_x >= 0);
			break;
		case 1:
			next_x = x;
			next_y = y+1;
			inarea = (next_y < board[x].length);
			break;
		case 2:
			next_x = x+1;
			next_y = y;
			inarea = (next_x < board.length);
			break;
		case 3:
			next_x = x;
			next_y = y-1;
			inarea = (next_y >= 0);
			break;
		default:
			break;
		}
		if (inarea) {
			if(!mark[next_x][next_y] && board[next_x][next_y]==word.charAt(index)) {
				boolean r0 = visit(board, mark, next_x, next_y,0, word, index+1);
				boolean r1 = visit(board, mark, next_x, next_y,1, word, index+1);
				boolean r2 = visit(board, mark, next_x, next_y,2, word, index+1);
				boolean r3 = visit(board, mark, next_x, next_y,3, word, index+1);
				if (r0||r1||r2||r3) {
					return true;
				}else{
					mark[next_x][next_y]=false;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
				// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(ws.board,"ABCEFSADEESE"));
	}
}
