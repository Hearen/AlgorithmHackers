package com.josh.task6;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	@Test
	public void test(){
		int[] preorder = {1,2,3,4,5,6,7,8};
		int[] inorder = {3,2,5,4,1,7,6,8};
		//TreeNode root = getTree(preorder,0,7,inorder,0,7);
		TreeNode root = buildTree(preorder, inorder);
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length) return null;
		if(preorder.length==1) return new TreeNode(preorder[0]);
		return getTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    //根据先序和中序构造二叉树
    public TreeNode getTree(int[] preorder,int p_s,int p_e, int[] inorder,int i_s,int i_e){
    	if(i_s<=i_e){
    		int rootPos = getRootPosFromInorder(inorder, i_s, i_e, preorder[p_s]);
    		int len = rootPos - i_s;
    		TreeNode root = new TreeNode(-1);
    		root.val = inorder[rootPos];
    		root.left = getTree(preorder, p_s+1, p_s+len, inorder, i_s, rootPos-1);
    		root.right = getTree(preorder, p_s+len+1, p_e, inorder, rootPos+1, i_e);
    		return root;
    	}
    	return null;
    }
    //根据先序中的第一个位置，及当前根curRootPos,遍历在中序中的位置，进而将中序分为左右两部分
    public int getRootPosFromInorder(int[] inorder,int i_s,int i_e,int curRootPos){
		for(int i=i_s;i<=i_e;i++){
			if(inorder[i] == curRootPos)
				return i;
		}
    	return -1;
    }
}
