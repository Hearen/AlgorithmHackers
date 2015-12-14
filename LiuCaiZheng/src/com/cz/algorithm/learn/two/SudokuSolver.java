package com.cz.algorithm.learn.two;

public class SudokuSolver {
	public static void main(String[] args) {

	}

	public void solveSudoku(char[][] board) {
		solution(board);
	}

	private boolean solution(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; k++) {
						board[i][j] = k;
						if (isValid(board, i, j) && solution(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	// check weather satisfy the condition
	private boolean isValid(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9 ; i ++) {
			if(y != i && board[x][y] == board[x][i] )  {
				return false;
			}
		}
		for(int i = 0 ; i < 9 ; i ++) {
			if(x  != i  && board[x][y] == board[i][y] ) {
				return false;
			}
		}
		for(int i = (x / 3) * 3 ;  i <  (x / 3) * 3 + 3 ; i ++) {
			for(int j = ( y / 3) * 3 ;  j < ( y / 3) * 3 + 3 ; j ++ ) {
				if (x != i && y != j && board[i][j] == board[x][y]) {  
                    return false;  
                }  
			}
		}
		return true;
	}
}
