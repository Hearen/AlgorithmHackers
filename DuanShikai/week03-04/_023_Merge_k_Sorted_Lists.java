package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2015年12月22日 下午10:11:51
 * @content 
 */

public class _023_Merge_k_Sorted_Lists {
	
	public static void main(String args[]){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=mergeKLists(new ListNode[]{l1,l2,l3});
	}
	
	private static ListNode mergeKLists(ListNode[] listNodes) {
		if(listNodes==null || listNodes.length==0) return null;
		if(listNodes.length==1) return listNodes[0];
		int size=listNodes.length;
		ListNode[] left=new ListNode[size/2];
		ListNode[] right=new ListNode[size-size/2];
		for(int i=0;i<listNodes.length;i++){
			if(i<size/2)
				left[i]=listNodes[i];
			else
				right[i-size/2]=listNodes[i];
		}
		return mergeLists(mergeKLists(left),mergeKLists(right));
	}

	//下面这种算法严重超时。
	public static ListNode mergeKLists_time_limited(ListNode[] lists) {
		ListNode result=null;
        for(ListNode list : lists)
        	result=mergeLists(list,result);
        return result;
    }
	
	public static ListNode mergeLists_(ListNode left,ListNode right){
		if(left == null) return right;
		if(right == null) return left;
		if(left.val<right.val){
			left.next=mergeLists_(left.next,right);
			return left;
		}
		else{
			right.next=mergeLists_(left,right.next);
			return right;
		}
	}
	
	public static ListNode mergeLists(ListNode left,ListNode right){
		if(left == null || right == null)
			return left==null ? right : left;
		ListNode head=left.val<right.val ? left : right;
		ListNode result=new ListNode(0);
		while(left!=null && right!=null){
			if(left.val<right.val){
				result.next=left;
				left=left.next;
			}
			else{
				result.next=right;
				right=right.next;
			}
			result=result.next;
		}
		if(left==null && right==null) return head;
		else if(left!=null) result.next=left;
		else result.next=right;
		return head;
	}

}
