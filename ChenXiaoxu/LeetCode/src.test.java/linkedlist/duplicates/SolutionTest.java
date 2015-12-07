package linkedlist.duplicates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedlist.List;
import linkedlist.ListNode;
import linkedlist.duplicates.I.Solution;

public class SolutionTest {

	private Solution solution = new Solution();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDeleteDuplicates() {
		List li = new List();
		li.insert(3);
		li.insert(3);
		li.insert(2);
		li.insert(1);
		li.insert(1);
		solution.deleteDuplicates(li.head);
		assertEquals(li.head.val, 1);
		assertEquals(li.head.next.val, 2);
	}

}
