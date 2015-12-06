package leetcode_njz;

public class _083_RemoveDuplicatesfromSortedList {

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		
	    ListNode rs = head;
	    ListNode pre = head;
	    ListNode now = head.next;
	    while(now != null){
	    	if(now.val != pre.val){
	    		pre.next = now;
	    		pre = pre.next;
	    	}
	    	now = now.next;
	    }
	    pre.next = now;
	    return rs;
	}
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next=a2;
//		ListNode a3 = new ListNode(1);a2.next=a3;
//		ListNode a4 = new ListNode(3);a3.next=a4;
//		ListNode a5 = new ListNode(3);a4.next=a5;
//		ListNode a6 = new ListNode(4);a5.next=a6;
		
		ListNode tmp = a1;
		while(tmp != null){
			System.out.print(tmp.val+" ");
			tmp = tmp.next;
		}
		
		ListNode rs = deleteDuplicates(a1);
		
		System.out.println();
		while(rs != null){
			System.out.print(rs.val+" ");
			rs = rs.next;
		}
	}

}
