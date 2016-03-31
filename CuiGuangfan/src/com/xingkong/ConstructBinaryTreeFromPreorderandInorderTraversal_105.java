package com.xingkong;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月7日 下午9:32:10 
 * class description
 */
public class ConstructBinaryTreeFromPreorderandInorderTraversal_105 {
//	private Map<Integer,Integer> preOrderMap=new HashMap<Integer,Integer>();
	private Map<Integer,Integer> inOrderMap=new HashMap<Integer,Integer>();
	public static class TreeNode {
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
	
	/**
	 * @param preorder
	 * @param inorder
	 * @param rootIndex preorder中的下一个元素
	 * @param startIndex 本次递归的inorder中的开始下标
	 * @param endIndex 本次递归的inorder中的结束下标
	 * @return
	 */
	public TreeNode backTrace(int[] preorder, int[] inorder,int rootIndex,int startIndex,int endIndex){
		if(startIndex>endIndex) return null;
		int midIndex=inOrderMap.get(preorder[rootIndex]);
		TreeNode root=new TreeNode(inorder[midIndex]);
		if(startIndex==endIndex)
			return root;
		int leftLength=midIndex-startIndex;//通过中序遍历获取左子树
		int rightLength=endIndex-midIndex;//通过中序遍历获取右子树
		//获取左子树部分
		root.left=backTrace(preorder,inorder,rootIndex+1,midIndex-leftLength,midIndex-1);
		//获取右子树部分
		root.right=backTrace(preorder,inorder,rootIndex+leftLength+1,midIndex+1,midIndex+rightLength);
		return root;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for(int i=0;i<preorder.length;i++){
//			preOrderMap.put(preorder[i], i);
			inOrderMap.put(inorder[i], i);
		}
		return backTrace(preorder,inorder,0,0,preorder.length-1);
	}

	public static void main(String[] args) {
		int[] preorder=new int[]{1,2,4,5,6,7,8,3,9,10,11,12,13};
		int[] inorder=new int[]{6,5,7,4,2,8,1,9,3,11,10,12,13};
		ConstructBinaryTreeFromPreorderandInorderTraversal_105 t=new ConstructBinaryTreeFromPreorderandInorderTraversal_105();
		TreeNode tn=t.buildTree(preorder, inorder);
		System.out.println(tn.val);
	}

}
