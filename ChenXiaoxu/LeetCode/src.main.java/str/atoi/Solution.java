package str.atoi;

public class Solution {
	public int myAtoi(String str) {
		if (str == null || str.isEmpty())
			return 0;
		str = str.trim();
		double result = 0;
		for (int i = 1; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				result = result * 10 + (str.charAt(i) - '0');
			else
				break;
		}
		if (str.charAt(0) == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;
	}
}
