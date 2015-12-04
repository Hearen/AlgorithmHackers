package leetcode.java.trappingrainwater;

/**
 * Based on
 * https://leetcode.com/discuss/63606/very-concise-java-solution-no-stack-with-
 * explanations
 * 
 * The idea is to set pointers at both ends and iterate inwards, harvesting
 * strips of volumes along the way.
 * 
 * S = highest section, V = volume, L = left, R = right.
 * 
 * @author wziyong
 *rumtime 2ms
 */
public class PremiumSolution {
	public int trap(int[] H) {
		int L = 0, R = H.length - 1, S = 0, V = 0;
		while (L < R)
			V += H[L] < H[R] ? (S = Math.max(S, H[L])) - H[L++] : (S = Math.max(S, H[R])) - H[R--];
		return V;
	}

}
