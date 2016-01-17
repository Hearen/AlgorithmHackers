#69. Sqrt(x)

## Problem

Implement int sqrt(int x).

Compute and return the square root of x.

Subscribe to see which companies asked this question

tag:
- math
- binary search

## Solution

**java**

```java
	public int mySqrt(int x) {
		long l = 0, r = x / 2 + 1;

		while (l <= r) {
			long m = (l + r) / 2; // may be over Integer.MAX_VALUE;
			if (m * m <= x && (m + 1) * (m + 1) > x)
				return (int) m;
			else if (m * m > x)
				r = m - 1;
			else
				l = m + 1;
		}
		return (int) r;
	}
```
