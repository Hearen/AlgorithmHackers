import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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

	// 63. Unique Paths II
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] res = new int[m][n];
		res[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
		for (int i = 1; i < m; i++) {
			res[i][0] = (obstacleGrid[i][0] == 1) ? 0 : res[i - 1][0];
		}
		for (int j = 1; j < n; j++) {
			res[0][j] = (obstacleGrid[0][j] == 1) ? 0 : res[0][j - 1];
		}
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					res[i][j] = 0;
				else
					res[i][j] = res[i - 1][j] + res[i][j - 1];
				res[i][j] = (obstacleGrid[i][j] == 1) ? 0 : (res[i - 1][j] + res[i][j - 1]);
			}
		return res[m - 1][n - 1];
	}

	// 115. Distinct Subsequences
	public int numDistinct(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] f = new int[m][n];
		for (int i = 0; i < m; i++)
			f[i][0] = 1;
		for (int j = 0; j < n; j++)
			for (int i = 0; i < m && i < j; i++)
				f[i][j] = 0;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (i == j)
					f[i][j] = s.substring(0, i) == t.substring(0, j) ? 1 : 0;
				else {
					if (s.charAt(i) == s.charAt(j))
						f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
					else
						f[i][j] = f[i - 1][j];
				}
			}
		return f[m - 1][n - 1];
	}

	// 6. ZigZag Conversion
	public String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		int cycle = 2 * numRows - 2;
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j += cycle) {
				if (j < s.length())
					res.append(s.charAt(j));
				if (i < numRows - 1 && i > 0) {
					int p = j + cycle - 2 * i;
					if (p < s.length())
						res.append(s.charAt(p));
				}
			}
		}
		return res.toString();
	}

	// 20. Valid Parentheses
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		String left = "([{", right = ")]}";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty() || s.charAt(i) != right.charAt(left.indexOf(stack.peek())))
					return false;
				stack.pop();
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}

	// 67. Add Binary
	public String addBinary(String a, String b) {
		StringBuffer res = new StringBuffer();
		int carry = 0;
		int i, j;
		for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
			int m = a.charAt(i) - '0', n = b.charAt(j) - '0';
			int r = m ^ n ^ carry;
			carry = (m + n + carry) > 1 ? 1 : 0;
			res.append(r);
		}
		if (i < 0 && j >= 0) {
			while (j >= 0) {
				res.append((b.charAt(j) - '0') ^ carry);
				carry = (b.charAt(j) - '0') & carry;
				j--;
			}
			if (carry == 1)
				res.append(carry);
		} else if (j < 0 && i >= 0) {
			while (i >= 0) {
				res.append((a.charAt(i) - '0') ^ carry);
				carry = (a.charAt(i) - '0') & carry;
				i--;
			}
			if (carry == 1)
				res.append(carry);
		} else {
			if (carry > 0)
				res.append(1);
		}
		return res.reverse().toString();
	}

	// 49. Group Anagrams
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String key = new String(tmp);
			List<String> li = map.get(key);
			if (li == null) {
				li = new ArrayList<String>();
			}
			li.add(str);
			map.put(key, li);
		}
		for (String key : map.keySet()) {
			List<String> value = map.get(key);
			Collections.sort(value);
			res.add(value);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.uniquePaths(2, 3));

		int obstacleGrid[][] = new int[][] { { 0 }, { 1 } };
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));

		System.out.println(s.numDistinct("abbc", "abc"));

		System.out.println(s.convert("PAYPALISHIRING", 3));

		System.out.println(s.isValid("["));

		System.out.println(s.addBinary("1", "1"));
	}

}