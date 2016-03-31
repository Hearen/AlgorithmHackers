package com.xingkong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月12日 下午9:02:45 
* class description
*/
public class N_36_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> mapRow=new HashMap<Integer,Set<Character>>();
        Map<Integer,Set<Character>> mapColumn=new HashMap<Integer,Set<Character>>();
        Map<Integer,Set<Character>> mapRect=new HashMap<Integer,Set<Character>>();
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[i].length;j++){
        		if(board[i][j]!='.'){
	        		if(!mapRow.containsKey(i)) mapRow.put(i, new HashSet<Character>());
	        		if(!mapRow.get(i).contains(board[i][j])) mapRow.get(i).add(board[i][j]);
	        		else 
	        			return false;
	        		if(!mapColumn.containsKey(j)) mapColumn.put(j, new HashSet<Character>());
	        		if(!mapColumn.get(j).contains(board[i][j])) mapColumn.get(j).add(board[i][j]);
	        		else 
	        			return false;
	        		if(!mapRect.containsKey(3*(i/3)+j/3)) mapRect.put(3*(i/3)+j/3, new HashSet<Character>());
	        		if(!mapRect.get(3*(i/3)+j/3).contains(board[i][j])) mapRect.get(3*(i/3)+j/3).add(board[i][j]);
	        		else 
	        			return false;
        		}
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		N_36_Valid_Sudoku n=new N_36_Valid_Sudoku();
		System.out.println(n.isValidSudoku(new char[][]{
			{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},
			{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},
			{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}
			}));

	}

}
