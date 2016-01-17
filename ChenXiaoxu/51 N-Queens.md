# 51. N-Queens

## Problem

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

tag:
- math
- binary search

## Solution

**java**

```java
public class Solution {

	public List<List<String>> solveNQueens(int n) {
		if (n == 0)
			return null;
		List solutions = new ArrayList();
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < n; i++)
			strbuf.append('.');
		int colIndex[] = new int[n];
		backTracking(solutions, colIndex, 0, n, strbuf.toString());
		return solutions;

	}

	void backTracking(List<List<String>> solutions, int[] colIndex, int rowIndex, int n, String str) {
		if (rowIndex == n) {
			List<String> solution = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				StringBuffer strbuf = new StringBuffer(str);
				strbuf.replace(colIndex[i], colIndex[i] + 1, "Q");
				solution.add(strbuf.toString());
			}
			solutions.add(solution);

		}

		else {
			for (int j = 0; j < n; j++) {
				if (check(colIndex, rowIndex, j)) {
					colIndex[rowIndex] = j;
					backTracking(solutions, colIndex, rowIndex + 1, n, str);
				}
			}
		}
	}

	boolean check(int[] colIndex, int rowIndex, int j) {
		for (int i = 0; i < rowIndex; i++) {
			if ((colIndex[i] == j) || (Math.abs(j - colIndex[i]) == (rowIndex - i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;

	}
}
```
