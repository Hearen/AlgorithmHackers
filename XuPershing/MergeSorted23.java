import java.util.List;

import javax.swing.event.ListDataEvent;

/**
 * @author xpxstar@gmail.com
 *
 * 2015年12月24日
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeSorted23 {
//	 Definition for singly-linked list.
	 public class ListNode {
	     int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	    public ListNode(int x,ListNode n) {
	    	val = x;
	    	next = n;
		}
	    public void setNext(ListNode n){
	    	next = n;
	    }
	 }
	 
	/**
	 * @param lists
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月24日
	 * Merge k sorted linked lists and return it as one sorted list. 
	 * Analyze and describe its complexity.
	 */
	public ListNode normalMergeKLists(ListNode[] lists) {
        if (null == lists || lists.length<1) {
			return null;
		}
		ListNode newList = getMin(lists);
        ListNode newNode,last = newList;
        while((newNode =getMin(lists)) != null){
        	last = addAtLast(last, newNode);
        }
        return newList;
    }
	private ListNode getMin(ListNode[] lists){
		ListNode mxLn = null;
		int maxIndex = 0;
		for (int k = 0;k< lists.length;k++) {
			if (null != lists[k]) {
				if (mxLn==null) {
					mxLn = lists[k];
					maxIndex = k;
				}else if(mxLn.val>lists[k].val){
					mxLn = lists[k];
					maxIndex = k;
				}
			}
		}
		lists[maxIndex] = lists[maxIndex] ==null? null:lists[maxIndex].next;
		return mxLn;
	}
	private ListNode addAtLast(ListNode last, ListNode newNode){
		last.next = newNode;
		newNode.next = null;
		return newNode;
	}
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (null == lists || lists.length<1) {
			return null;
		}
		
		initMinHeap(lists);
		ListNode newList = getMinWithHeap(lists);
        ListNode newNode,last = newList;
        while((newNode =getMinWithHeap(lists)) != null){
        	last = addAtLast(last, newNode);
        }
        return newList;
	}
	private void initMinHeap(ListNode[] lists){
		ListNode forSwap;
		for (int k = 0;k<lists.length ;k++) {
			if (null != lists[k]) {
				int tmp = k;
				while(lists[(tmp-1)/2]==null || lists[tmp].val < lists[(tmp-1)/2].val){
					forSwap = lists[tmp];
					lists[tmp] = lists[(tmp-1)/2];
					lists[(tmp-1)/2] = forSwap;
					tmp = (tmp-1)/2;
				}
			}
		}
	}
	private ListNode getMinWithHeap(ListNode[] lists){
		ListNode min = lists[0];
		if (min != null) {
			lists[0] = lists[0].next;
			int child = 1;
			ListNode forSwap = lists[0];
			while(child < lists.length && (lists[child+1] !=null || null != lists[child])){
				child = (child > lists.length-2 || lists[child+1] ==null ||(null != lists[child]&&lists[child].val < lists[child+1].val))?child:child+1;
				if(forSwap==null || lists[child].val < forSwap.val){
					lists[(child-1)/2]=lists[child];
					lists[child] = forSwap;
				}else {
					break;
				}
				child = child*2+1;
				
			}
		}
		return min;
	}
	public static void main(String[] args) {
		MergeSorted23 ms = new MergeSorted23();
		ListNode[] lists = {ms.new ListNode(1),ms.new ListNode(2)};//,ms.new ListNode(3),ms.new ListNode(0),ms.new ListNode(5)};
//		lists[0].setNext(ms.new ListNode(5,ms.new ListNode(7)));
//		lists[1].setNext(ms.new ListNode(6,ms.new ListNode(14)));
//		lists[2].setNext(ms.new ListNode(4,ms.new ListNode(8)));
//		lists[3].setNext(ms.new ListNode(9,ms.new ListNode(11)));
//		lists[4].setNext(ms.new ListNode(13,ms.new ListNode(16)));
		ListNode ln= ms.mergeKLists(lists);
		ListNode tmp = ln;
		while (tmp!=null){
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}

}
