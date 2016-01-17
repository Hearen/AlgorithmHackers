package linkedlist;

public class List {
	public ListNode head;

	public List() {
		head = null;
	}

	public void insert(int val) {
		ListNode tmp = new ListNode(val);
		if (head != null) {
			tmp.next = head;
			head = tmp;
		} else {
			head = tmp;
		}
	}

	void delete(ListNode node) {

	}
}