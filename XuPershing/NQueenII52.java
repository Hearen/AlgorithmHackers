public class NQueenII52 {
	/**
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月28日
	 * Follow up for N-Queens problem.
	 * Now, instead outputting board configurations, 
	 * return the total number of distinct solutions.
	 */
	int result = 0;
	public int totalNQueens(int n) {
		/*
		 * 思路：回溯，深搜。
		 * 遍历每一行，找下一行合法的皇后位置，pos记录当前已经走的位置
		 * n表示下一行的行号，size是皇后个数。
		 * 如果合法，继续找下一行，如果不合法，跳出当前层，上一层继续搜索合法位置。
		 * 这里的合法，即pos中相同位置，或者斜对角的位置（使用原来行与当前行差，加减原来位置，定位斜对角）
		 * 当深搜到n个皇后之后，结束
		 *
		 */
		if (n<1) {
			return 0;
		}
		int[] pos = new int[n];
		findNext(pos, 0, n);
		return result;
    }
	private void findNext(int[] pos,int n,int size){
		if (n==size) {
			result++;
			return;
		}
		for (int i= 0;i<size;i++) {
				if(checkVaild(pos, n, i)){
					pos[n] = i;
					findNext(pos, n+1, size);
				}
			}
	}
	private boolean checkVaild(int[] pos,int n,int test){
		for (int i = 0; i < n; i++) {
			if (test == pos[i]||test == n-i+pos[i]||test == pos[i]-n+i) {
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = new NQueenII52().totalNQueens(9);
		System.out.println(r);
		
	}

}
