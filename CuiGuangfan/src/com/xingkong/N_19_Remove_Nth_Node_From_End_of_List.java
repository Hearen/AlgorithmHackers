package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月7日 下午10:28:04 
* class description
*/
public class N_19_Remove_Nth_Node_From_End_of_List {
	private class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode first=head;
		ListNode second=first;
		while(n-->0) {
			second=second.next;
			if(second==null){
				return head.next;
			}
		}
		while(second.next!=null){
			first=first.next;
			second=second.next;
		}
		first.next=first.next!=null?first.next.next:null;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//一次测试通过，无需写用例
	}
}
