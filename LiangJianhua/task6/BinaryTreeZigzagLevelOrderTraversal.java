package com.josh.task6;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversal {
	//初始化二叉树
	public TreeNode iniBinaryTree(){
		
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
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
		TreeNode root = iniBinaryTree();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = zigzagLevelOrder(root);
		for(int i=0;i<list.size();i++){
			System.out.print("第"+(i+1)+"层元素： ");
			for(int j=0;j<list.get(i).size();j++){
				System.out.print(list.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int depath = getMaxDepth(root);
        for(int i=1;i<depath+1;i++){
        	List<Integer> levelList = new ArrayList<Integer>();
        	transLevel(root,i,levelList);
        	if(i%2 == 0){//反序输出
            	List<Integer> afterSortList = new ArrayList<Integer>();
            	for(int k=levelList.size()-1;k>=0;k--){
            		afterSortList.add(levelList.get(k));
            	}
            	list.add(afterSortList);
        	}else{//顺序输出
        		list.add(levelList);
        	}
        }
        return list;
    }
	//打印二叉树某一层的节点
	public void transLevel(TreeNode root, int level,List<Integer> list){
		if(root==null) 
			return;
		else{
			if(level == 1){ 
				list.add(root.val);
			}else{
				transLevel(root.left, level-1,list);
				transLevel(root.right, level-1,list);
			}
		}
	}
	//得到二叉树最大高度
	public int getMaxDepth(TreeNode root) {
		if(root == null) return 0;
		else{
			int left = getMaxDepth(root.left);
			int right = getMaxDepth(root.right);
			return 1+Math.max(left, right);
		}
		
	}
}
