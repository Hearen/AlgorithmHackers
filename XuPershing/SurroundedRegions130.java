import java.util.HashMap;
import java.util.Map;

public class SurroundedRegions130 {
	/**
	 * @param board
	 * @author xpxstar@gmail.com
	 * @2015Äê12ÔÂ28ÈÕ
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
	 */
	int[][] direct = {{-1,0},{0,1},{1,0},{0,-1}};
	int height;
	int width;
	public void solve(char[][] board) {
		if (null == board ||board.length<1) {
			return;
		}
		
		height = board.length-1;
		width = board[0].length-1;
        for (int i = 0;i <= width;i++) {
			if ('O' == board[0][i]) {
				board[0][i] = 'k';
				save(board, 0, i);
			}
			if ('O' == board[height][i]) {
				board[height][i] = 'K';
				save(board, height, i);
			}
		}
        for (int i = 0;i <= height;i++) {
			if ('O' == board[i][0]) {
				board[i][0] = 'K';
				save(board, i, 0);
			}
			if ('O' == board[i][width]) {
				board[i][width] = 'K';
				save(board, i,width);
			}
		}
        for (int i = 0;i <= width;i++) {
			for (int j = 0; j <= height; j++) {
				if ('O' == board[j][i]) {
					board[j][i] = 'X';
				}else if ('K' == board[j][i]) {
					board[j][i] = 'O';
				}
			}
		}
        return ;
    }
	private void save(char[][] board,int x,int y){
		if (isAlive(board, x+direct[0][0], y+direct[0][1])) {
			save(board, x+direct[0][0], y+direct[0][1]);
		}
		if (isAlive(board, x+direct[1][0], y+direct[1][1])) {
			save(board, x+direct[1][0], y+direct[1][1]);
		}
		if (isAlive(board, x+direct[2][0], y+direct[2][1])) {
			save(board, x+direct[2][0], y+direct[2][1]);
		}
		if (isAlive(board, x+direct[3][0], y+direct[3][1])) {
			save(board, x+direct[3][0], y+direct[3][1]);
		}
	}
	private boolean isAlive(char[][] board,int x,int y){
		if (x<0||x>height) {
			return false;
		}
		if (y<0||y>width) {
			return false;
		}
		if ('O' == board[x][y]) {
			board[x][y] = 'K';
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		char[][] bb = {{'X','K','X','K','X','K'},
//						{'O','O','O','X','O','X'},
//						{'X','O','X','O','O','X'},
//						{'O','X','O','X','O','X'}};
//		new SurroundedRegions130().solve(bb);
//		Map<Integer, Boolean> m = new HashMap<>();
//		m.hashCode();
//		Integer a = 1;
//		Integer b = 1;
//		System.out.println(a==b);
//		a = new Integer(1);
//		b = new Integer(1);
//		System.out.println(a==b);
//		System.out.println(a.equals(b));
//		a = new Integer('1');
//		b = new Integer(1);
//		System.out.println(a==b);
//		Integer a = 1;
//		Integer b = 1;
//		a = Integer.valueOf(1);
//		b = Integer.valueOf("1");
//		System.out.println(a==b);
		for(int i = 0;i<78 ;i++){
			System.out.println("<img data-onclick=\""+i+"\" src=\"./images/small/"+i+".jpg\">");
		}
	}

}
