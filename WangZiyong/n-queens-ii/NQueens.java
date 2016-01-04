package datastructrue.backtrack;

/**
 * 回溯法求解 N 皇后问题
 * 
 */
public class NQueens
{
	public int n = 4;

	// x[i]=j,表示第i行，第j列放一个皇后
	public int[] x = new int[n];

	public void nQueens()
	{
		x[0] = -1;
		int k = 0;// k表示行，即第几个皇后。//第一行开始；-1列
		while (k > -1)
		{
			x[k] = x[k] + 1;// 查找下一个位置（列）

			// 从x[k]~(n-1)，循环查看是否可以放置皇后；
			while (x[k] < n && !place(k))
			{
				x[k] = x[k] + 1;
			}

			if (x[k] < n) // 判断是否越界，如果越界，则回溯。
			{
				if (k == (n - 1)) // 如果k达到最多个皇后，则表示有一个解了。然后，循环开始，尝试下一列！
				{
					// print result
					for (int tmp : x)
					{
						System.out.print(tmp);
					}
				}
				else// 寻找下一行解
				{
					k = k + 1;
					x[k] = -1;
				}
			}
			else
			{
				// 回溯
				k = k - 1;
			}
		}
	}

	// 约束函数
	private boolean place(int k)
	{
		boolean place = true;
		for (int j = 0; j <= k - 1; j++)
		{
			// 不同列，不同对角线;显然是不同行的！
			if (x[j] == x[k] || (Math.abs(k - j) == Math.abs(x[k] - x[j])))
			{
				place = false;
			}
		}
		return place;
	}

	public static void main(String[] args)
	{
		NQueens q = new NQueens();
		q.nQueens();
	}

}
