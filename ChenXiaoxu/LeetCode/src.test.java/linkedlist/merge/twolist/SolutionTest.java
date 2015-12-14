package linkedlist.merge.twolist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedlist.List;
import linkedlist.merge.twolist.Solution;

public class SolutionTest {

	private Solution solution = new Solution();
	private List l1 = new List();
	private List l2 = new List();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMergeTwoLists() {
		// null, null
		assertEquals(null, solution.mergeTwoLists(l1.head, l2.head));
		// 3,5,8,11
		// 2,6,8,9,11,15,20

		l1.insert(11);

		assertEquals(11, solution.mergeTwoLists(l1.head, l2.head).val);
		l1.insert(8);
		l1.insert(8);
		l1.insert(3);

		l2.insert(20);
		l2.insert(15);
		l2.insert(11);
		l2.insert(9);
		l2.insert(8);
		l2.insert(6);
		l2.insert(2);

		assertEquals(2, solution.mergeTwoLists(l1.head, l2.head).val);

		System.out.println();

	}

}
