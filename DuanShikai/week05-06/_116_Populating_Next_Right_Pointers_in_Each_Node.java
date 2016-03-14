package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年1月5日 下午6:16:50
 * @content 
 */

public class _116_Populating_Next_Right_Pointers_in_Each_Node {
	
	public static void main(String args[]){
		TreeLinkNode _1=new TreeLinkNode(1);
		TreeLinkNode _2=new TreeLinkNode(2);
		TreeLinkNode _3=new TreeLinkNode(3);
		TreeLinkNode _4=new TreeLinkNode(4);
		TreeLinkNode _5=new TreeLinkNode(5);
		TreeLinkNode _6=new TreeLinkNode(6);
		TreeLinkNode _7=new TreeLinkNode(7);
		TreeLinkNode _8=new TreeLinkNode(8);
		_1.left=_2; _1.right=_3;
		_2.left=_4; _2.right=_5; _3.right=_6;
		_4.left=_7; _6.right=_8;
		connect_(_1);
	}

	

	//使用额外的空间,解决完全二叉树和非完全二叉树的问题
	public void connect(TreeLinkNode root) {
		if(root==null || (root.left==null && root.right==null)) return ;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		TreeLinkNode first,second;
		while(!queue.isEmpty()){
			int size=queue.size(); int k=1;
			first = queue.poll();
			if(first.left!=null) queue.add(first.left);
			if(first.right!=null) queue.add(first.right);
			while(++k<=size){
				second = queue.poll();
				if(second.left!=null) queue.add(second.left);
				if(second.right!=null) queue.add(second.right);
				first.next=second;
				first=second;
			}
		}
    }
	
	//不使用额外的空间，解决完全二叉树的问题，找到一个pattern.
	public void connect_1(TreeLinkNode left,TreeLinkNode right){
		if(left!=null && right!=null){
			left.next=right;
			connect_1(left.left,left.right);
			connect_1(left.right,right.left);
			connect_1(right.left,right.right);
		}
	}
	
	public static void connect_(TreeLinkNode root){
		TreeLinkNode level=new TreeLinkNode(0); //申请一个额外的空间
		TreeLinkNode curr=level; level.next=root;
		while(root!=null){
			curr=level;
			while(root!=null){ //遍历这一层的元素
				if(root.left!=null) { curr.next=root.left;  curr=curr.next; }
				if(root.right!=null){ curr.next=root.right; curr=curr.next; }
				root=root.next;
			}
			root=level.next;
			level.next=null;//MISTAKE 注意如果不加上这一句将陷入死循环
		}
	}
	
	//不使用额外的空间，但是没有找到这样的pattern,解是错误的。
	public static void connect_wrong_answer(TreeLinkNode root){
		if(root==null || (root.left==null && root.right==null)) return ;
		connect_2(root.left,root.right);
	}
	public static void connect_2(TreeLinkNode left,TreeLinkNode right){
		if(left!=null && right!=null){
			left.next=right;
			if(left.left!=null){
				if(left.right!=null){
					connect_2(left.left,left.right);
					if(right.left!=null){
						connect_2(left.right,right.left);
						if(right.right!=null){
							connect_2(right.left,right.right);
						}
					}else if(right.right!=null){
						connect_2(left.right,right.right);
					}
				}else{
					if(right.left!=null){
						connect_2(left.left,right.left);
						if(right.right!=null){
							connect_2(right.left,right.right);
						}
					}else if(right.right!=null){
						connect_2(left.left,right.right);
					}
				}
			}else if(left.right!=null){
				if(right.left!=null){
					connect_2(left.right,right.left);
					if(right.right!=null)
						connect_2(right.left,right.right);
				}
				else if(right.right!=null)
					connect_2(left.right,right.right);
			}else if(right.left!=null){
				if(right.right!=null)
					connect_2(right.left,right.right);
			}
		}
	}
	
	public static class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	}	
	
}


