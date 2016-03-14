import javax.swing.text.html.CSS;

public class Convert2BST109 {
	
	public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
		}
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	     ListNode(int x ,ListNode n) {val = x; next = n; }
	 }
	/**
	 * @param head
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016Äê1ÔÂ11ÈÕ
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null ) {
			return null;
		}
		if (head.next == null ) {
			return new TreeNode(head.val);
		}
		ListNode tn = head;
		ListNode mid = head;
		while(tn.next!=null){
			tn = tn.next.next;
			if (null == tn) {
				break;
			}
			mid = mid.next;
		}
		tn = mid.next;
		mid.next = null;
		TreeNode root = new TreeNode(tn.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(tn.next);
		return root;
	}
	public static void main(String[] args) {
		Convert2BST109 c2 = new Convert2BST109();
		ListNode root = c2.new ListNode(1,c2.new ListNode(2,c2.new ListNode(3,c2.new ListNode(4,c2.new ListNode(5,c2.new ListNode(6))))));
		
		TreeNode tn = c2.sortedListToBST(root);
		System.out.println(tn.val);
	}
}
