package com.josh.task6;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeII {
	//初始化二叉树
	public TreeLinkNode iniTreeLinkNode(){
		
		TreeLinkNode node1 = new TreeLinkNode(3);
		TreeLinkNode node2 = new TreeLinkNode(9);
		TreeLinkNode node3 = new TreeLinkNode(20);
		TreeLinkNode node4 = new TreeLinkNode(15);
		TreeLinkNode node5 = new TreeLinkNode(7);
		node1.left = node2;
		node1.right = node3;
		
		node2.left = null;
		node2.right = null;
		
		node3.left = node4;
		node3.right = node5;
		
		node4.left = null;
		node4.right = null;
		
		node5.left = null;
		node5.right = null;
		
		return node1;
	}
	@Test
	public void test(){
		TreeLinkNode root = iniTreeLinkNode();
//		List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
//		transLevel(root, 2, list);
		connect(root);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).val);
//		}
	}
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		int depath = getMaxDepth(root);
		for(int i=1;i<depath+1;i++){
			List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
			transLevel(root,i, list);
			int count = 0;
			while(count<list.size()-1){
				list.get(count).next = list.get(count+1);
				count++;
			}
			list.get(count).next = null;
			
			//test
//			TreeLinkNode head = list.get(0);
//			while(head.next !=null){
//				System.out.print(head.val+" ");
//				head = head.next;
//			}
//			System.out.println(head.val+" ");
		}
		
    }
	//打印二叉树某一层的节点
	public void transLevel(TreeLinkNode root, int level,List<TreeLinkNode> list){
		if(root==null) 
			return;
		else{
			if(level == 1){ 
				list.add(root);
			}else{
				transLevel(root.left, level-1,list);
				transLevel(root.right, level-1,list);
			}
		}
	}
	//得到二叉树最大高度
	public int getMaxDepth(TreeLinkNode root) {
		if(root == null) return 0;
		else{
			int left = getMaxDepth(root.left);
			int right = getMaxDepth(root.right);
			return 1+Math.max(left, right);
		}
		
	}
}
