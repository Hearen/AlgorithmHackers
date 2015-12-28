package math.sqrt;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import math.Solution;

public class SolutionTest {

	private Solution s = new Solution();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMySqrt() {
		int[] testCase = {0,1,2,3,4,5,6,7,8,9};
		int[] expect = {0, 1, 1, 1, 2, 2, 2, 2, 2, 3};
		for (int i=0; i<testCase.length; i++) {
			Assert.assertEquals(expect[i], s.mySqrt(testCase[i]));
		}
	}

}
