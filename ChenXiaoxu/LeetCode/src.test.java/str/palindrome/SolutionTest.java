package str.palindrome;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest extends Solution {

	private Solution solution = new Solution();

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testIsPalindrome() {
		String s0 = null;
		Assert.assertEquals(true, solution.isPalindrome(s0));
		String s1 = "";
		Assert.assertEquals(true, solution.isPalindrome(s1));
		String s2 = "    ";
		Assert.assertEquals(true, solution.isPalindrome(s2));
		String s3 = "A man, a plan, a canal: Panama";
		Assert.assertEquals(true, solution.isPalindrome(s3));
		String s4 = "a; b , 1 ,2 ,3!321,ba;    ";
		Assert.assertEquals(true, solution.isPalindrome(s4));

		String s5 = "123,abcdef";
		Assert.assertEquals(false, solution.isPalindrome(s5));

	}

}
