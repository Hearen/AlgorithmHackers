package week7;

public class ShortestPalindrome214 {
	/**
	 * @param s
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016Äê1ÔÂ14ÈÕ
	 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
	 */
	public String shortestPalindrome(String s) {
		if (s.length()<2) {
			return s;
		}
        StringBuffer sb  = new StringBuffer(s.length());
        int left = 0,right = s.length()-1;
        int lastHead = 0;
        int head = 0;
        boolean second = true;
        while (left < right) {
			if (s.charAt(0) == s.charAt(right) && second) {
				head = lastHead;
				lastHead = right;
				second = false;
			}
			if (s.charAt(left) == s.charAt(right)){
				right--;
				left++;
			}else {
				if (second) {
					left = 0;
					right--;
				}else {
					left = 1;
					right = lastHead-1;
				
				}
				second = true;
			}
		}
        left = head == 0?lastHead:head;
        right = s.length()-left;
        for (int i = s.length()-1; i > left; i--) {
			sb.append(s.charAt(i));
		}
        sb.append(s);
        return sb.toString();
    }
	public static void main(String[] args) {
		ShortestPalindrome214 sp = new ShortestPalindrome214();
		System.out.println(sp.shortestPalindrome("baaaab"));
	}

}
