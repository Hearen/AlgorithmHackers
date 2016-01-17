package str.atoi;

public class Solution {
	public int myAtoi(String str) {
		if (str == null || str.isEmpty())
			return 0;
		
		str = str.trim();
		
		int index = 0;
		int sign = 1;
		long result = 0;
		if (str.charAt(index) == '-') {
			sign = -1;
			index++;
		} else if (str.charAt(index) == '+') {
			index++;
		}
		for (; index < str.length(); index++) {
			if (!Character.isDigit(str.charAt(index)))
				break;
			result = result * 10 + (str.charAt(index) - '0');
			if (result > Integer.MAX_VALUE)
				break;
		}
		
		result = sign * result;
		if (result >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int) result;
	}
}
