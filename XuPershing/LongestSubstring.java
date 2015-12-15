public class LongestSubstring {
	String ss = "abcedefabfdas";
	/**
	 * @param s
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月14日
	 * Given a string, find the length of the longest substring without repeating characters.
	 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
	 *  which the length is 3. For "bbbbb" the longest substring is "b",
	 *  with the length of 1.
	 */
	public int lengthOfLongestSubstring(String s) {
		/*思路：遍历字符串，寻找以当前开始的最长字符串
		 * 然后找到最长的。
		 * 复杂度
		 * O(N^3)
		 */
		if (s.length()<2) {
			return s.length();
		}
		int maxLen = 0;
		for(int i = 0; i < s.length()-1; i++){
			int j = 1;
			while(i+j < s.length() && -1 == s.substring(i,i+j).indexOf(s.charAt(i+j))){
				j++;
			}
			maxLen = j > maxLen?j:maxLen;
		}
		return maxLen;
        
    }
	
	public int lengthOfLongestSubstringUP(String s) {
		/*思路：遍历字符串，寻找以当前开始的最长字符串
		 * 然后找到最长的。
		 */
		
		if (s.length()<2) {
			return s.length();
		}
		int maxLen = 0;
		for(int i = 0; i < s.length()-1; i++){
			int j = 1;
			while(i+j < s.length() && -1 == s.substring(i,i+j).indexOf(s.charAt(i+j))){
				j++;
			}
			maxLen = j > maxLen?j:maxLen;
		}
		return maxLen;
        
    }
	public static void main(String[] args) {
		LongestSubstring  ls = new LongestSubstring();
		System.out.println(ls.lengthOfLongestSubstring(ls.ss));
	}

}
