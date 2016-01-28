import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length + 1; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length];
	}

	// 264. Ugly Number II
	public int nthUglyNumber(int n) {
		List<Integer> ugly = new ArrayList<Integer>(n);
		ugly.add(1);
		int p2 = 0, p3 = 0, p5 = 0;
		while (ugly.size() < n) {
			int min = min(ugly.get(p2) * 2, ugly.get(p3) * 3, ugly.get(p5) * 5);
			if (min == ugly.get(p2) * 2)
				p2 += 1;
			if (min == ugly.get(p3) * 3)
				p3 += 1;
			if (min == ugly.get(p5) * 5)
				p5 += 1;
			ugly.add(min);
		}
		return ugly.get(n - 1);
	}

	int min(int a, int b, int c) {
		int min = Math.min(a, b);
		min = Math.min(min, c);
		return min;
	}

	// 62. Unique Paths
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++)
			res[i][0] = 1;
		for (int j = 0; j < n; j++)
			res[0][j] = 1;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				res[i][j] = res[i - 1][j] + res[i][j - 1];
		return res[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.uniquePaths(2, 3));
	}
}