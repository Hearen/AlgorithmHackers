package com.josh.task6;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class ConvertSortedListToBinarySearchTree {
	
	public ListNode iniListNode(){
		ListNode head = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);
		
		head.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		listNode7.next = null;
		
		return head;
	}
	@Test
	public void test(){
		ListNode head = iniListNode();
		TreeNode root = sortedListToBST(head);
		//层次遍历构造的二叉查找树树
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode curNode = queue.remove();
			int e = curNode.val;
			System.out.print(e+" ");
			if(curNode.left != null) queue.add(curNode.left);
			if(curNode.right != null) queue.add(curNode.right);
		}
	}

    public TreeNode sortedListToBST(ListNode head) {
    	if(head==null) return null;
    	if(head.next==null) return new TreeNode(head.val);
    	int count = 1;
    	ListNode tempCount = head;
    	while(tempCount.next != null){//计算ListNode长度
    		count ++;
    		tempCount = tempCount.next;
    	}
    	int[] num = new int[count];
    	int i=0;
    	while(head.next != null){//ListNode转化为num数组
    		num[i] = head.val;
    		i++;
    		head = head.next;
    	}
    	num[i] = head.val;
		TreeNode root = getMidNode(0, num.length-1, num);//构造二叉搜索树
		TreeNode last = new TreeNode(num[num.length-1]);//添加最后一个元素
		TreeNode tempNode = root;
		while(tempNode.right !=null){
			tempNode = tempNode.right;
		}
		tempNode.right = last;
		return root;
    }
	//递归-根据有序数组构造二叉查找树
	public TreeNode getMidNode(int s,int e,int[] num){
		TreeNode root = new TreeNode(-1);
		if(s<e){
			int mid = (s+e)/2;
			root.val = num[mid];
			root.left = getMidNode(s, mid, num);
			root.right = getMidNode(mid+1, e, num);
			return root;
		}
		return null;
	}
}
