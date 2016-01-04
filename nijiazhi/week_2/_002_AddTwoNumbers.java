package leetcode_njz;

public class _002_AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		int temp = 0;
		ListNode node = new ListNode(0);
		ListNode rs = node;
		
		while (l1 !=null || l2!=null){
			if(l1 != null){
				temp += l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null){
				temp +=  l2.val;
				l2 = l2.next;
			}
			
			node.next = new ListNode(temp % 10);
			node = node.next;
			temp /= 10;
		}//end while
		
		if(temp == 1)
			node.next = new ListNode(1);
		
		return rs.next;
	}
	
	public static void print(ListNode node){
		while (node!=null){
			System.out.print(node.val+" -> ");
			node = node.next;
		}
	}
	
	public static void main(String[] args){
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		
		print(a1);
		System.out.println();
		print(b1);
		System.out.println("\n");
		ListNode c = addTwoNumbers(a1, b1);
		print(a1);
		System.out.println();
		print(b1);
		System.out.println("\n");

		
		print(c);
	}
}
