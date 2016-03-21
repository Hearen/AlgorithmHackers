package com.xingkong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月6日 下午10:29:04 class description
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return "TreeNode [val=" + val+ "]";
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(root==null) return list;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		queue.add(root);
		stack.push(root);
		int flag=0;
		//偶数次读队列，奇数次读栈
		while(!queue.isEmpty()&&!stack.isEmpty()){
			List<Integer> tempList=new ArrayList<Integer>();
			Queue<TreeNode> currentQueue=new LinkedList<TreeNode>();
			Stack<TreeNode> currentStack=new Stack<TreeNode>();
			if(flag%2==0){
				while(!queue.isEmpty()){
					TreeNode tnValue = queue.poll();
					tempList.add(tnValue.val);
					TreeNode tnNext =tnValue;
					if(tnNext.left!=null){
						currentQueue.add(tnNext.left);
						currentStack.push(tnNext.left);
					}
					if(tnNext.right!=null){
						currentQueue.add(tnNext.right);
						currentStack.push(tnNext.right);
					}
				}
			}else{
				while(!stack.isEmpty()){
					TreeNode tnValue = stack.pop();
					tempList.add(tnValue.val);
					TreeNode tnNext =queue.poll();
					if(tnNext.left!=null){
						currentQueue.add(tnNext.left);
						currentStack.push(tnNext.left);
					}
					if(tnNext.right!=null){
						currentQueue.add(tnNext.right);
						currentStack.push(tnNext.right);
					}
					
					
				}
			}
			list.add(tempList);
			queue=currentQueue;
			stack=currentStack;
			flag++;
		}
		return list;
	}

	public static void main(String[] args) {
//		TreeNode tn1=new TreeNode(3);
//		TreeNode tn2=new TreeNode(9);
//		TreeNode tn3=new TreeNode(20);
//		TreeNode tn4=new TreeNode(11);
//		TreeNode tn5=new TreeNode(4);
//		TreeNode tn6=new TreeNode(15);
//		TreeNode tn7=new TreeNode(7);
//		TreeNode tn8=new TreeNode(8);
//		TreeNode tn9=new TreeNode(6);
//		TreeNode tn10=new TreeNode(13);
//		TreeNode tn11=new TreeNode(14);
//		TreeNode tn12=new TreeNode(22);
//		TreeNode tn13=new TreeNode(23);
//		tn1.left=tn2;
//		tn1.right=tn3;
//		tn2.left=tn4;
//		tn2.right=tn5;
//		tn3.left=tn6;
//		tn3.right=tn7;
//		tn4.left=tn8;
//		tn4.right=tn9;
//		tn5.left=tn10;
//		tn6.right=tn11;
//		tn10.left=tn12;
//		tn11.right=tn13;
		BinaryTreeZigzagLevelOrderTraversal_103 btzlo=new BinaryTreeZigzagLevelOrderTraversal_103();
		System.out.println(btzlo.zigzagLevelOrder(null));
	}

}
