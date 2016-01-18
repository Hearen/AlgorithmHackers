package leetcode.java.ShortestPalindrome;

/**
 * The idea is to use two anchors j and i to compare the String from beginning and end.
 * 
 * If j can reach the end, the String itself is Palindrome.
 * 
 * Otherwise, we divide the String by j, and get mid = s.substring(0, j) and suffix.
 * 
 * We reverse suffix as beginning of result and recursively call shortestPalindrome to
 * 
 * get result of mid then appedn suffix to get result.
 * 
 * https://leetcode.com/discuss/52564/a-kmp-based-java-solution-with-explanation
 * 
 * 
 * I understand as this way:
 * 
 * After KMP run, it returns a prefix function of each character.
 * 
 * The physical meaning of it is that it is the size of the longest prefix
 * 
 * of the string that is also a suffix of the string.
 * 
 * For example: "abcdab". The size function for it is [0,0,0,0,1,2].
 * 
 * The last value tells the size of the longest prefix is 2, which is "ab".
 */
public class ShortestPalindromeV1
{
	public static String shortestPalindrome(String s)
	{
		if (s.length() <= 1)
			return s;
		String new_s = s + "#" + new StringBuilder(s).reverse().toString();

		// 表示已经匹配了多大的长度
		int[] position = new int[new_s.length()];

		// 从头开始往后遍历，递推的方式来求
		// For example: "abcdab". The position[] is [0,0,0,0,1,2].
		for (int i = 1; i < position.length; i++)
		{
			// i上一个元素，已经匹配的长度，因此，此时pre_pos应该与i元素比较；
			int pre_pos = position[i - 1];

			// 依次循环，直到：到了头；或者相等了！
			while (pre_pos > 0 && new_s.charAt(pre_pos) != new_s.charAt(i))
				pre_pos = position[pre_pos - 1];

			// 设置i的匹配位置
			position[i] = pre_pos + ((new_s.charAt(pre_pos) == new_s.charAt(i)) ? 1 : 0);
		}

		return new StringBuilder(s.substring(position[position.length - 1])).reverse().toString() + s;
	}

	public static void main(String[] args)
	{
		shortestPalindrome("abac");
	}

}
