package linkedlist.merge.klist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedlist.List;
import linkedlist.ListNode;

public class SolutionTest {

	private Solution solution = new Solution();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testMergeKLists() {

		ListNode[] lists0 = null;
		ListNode[] lists1 = new ListNode[3];
		List l1 = new List();
		List l2 = new List();
		List l3 = new List();
		l1.insert(11);
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

		l3.insert(20);
		l3.insert(1);
		lists1[0] = l1.head;
		lists1[1] = l2.head;
		lists1[2] = l3.head;

		ListNode[] list2 = new ListNode[2];
		List l20 = new List();
		List l21 = new List();
		l21.insert(1);
		list2[0] = l20.head;
		list2[1] = l21.head;

		assertEquals(null, solution.mergeKLists(lists0));

		assertEquals(1, solution.mergeKLists(lists1).val);

		assertEquals(1, solution.mergeKLists(list2).val);
	}

}
