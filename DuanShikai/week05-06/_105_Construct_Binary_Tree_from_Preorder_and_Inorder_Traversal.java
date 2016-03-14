package com.sky.leetcode;

import java.util.Arrays;

/**
 * @author DuanSky
 * @date 2016年1月7日 上午9:04:22
 * @content 
 */

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	
	public static void main(String args[]){
		int[] preorder = {7,-10,-4,3,-1,2,-8,11};
		int[] inorder = {-4,-10,3,-1,7,11,-8,2};
		_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal test = new _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		TreeNode re=test.buildTree(preorder, inorder);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null || preorder.length==0) return null;
        return generate(preorder,inorder,0,inorder.length-1,0);
    }
	
	//不采用额外的空间
	public TreeNode generate(int[] preorder,int[] inorder,int start,int end,int pos){
		if(start>end || pos>=inorder.length) return null;
		TreeNode root = new TreeNode(preorder[pos]); //pos指向树根的位置
		int pivot = find(inorder,start,end,preorder[pos]); //根据树根将中序遍历分成两半
		root.left = generate(preorder,inorder,start,pivot-1,pos+1);
		root.right = generate(preorder,inorder,pivot+1,end,pos+pivot-start+1);//MISTAKE 本题的关键是如何计算偏移量
		return root;
	}
	
	
	//采用o(n)空间，将中序遍历依次划分成两个子集
	public TreeNode generate(int[] preorder,int[] inorder,int pos){
		if(inorder == null || inorder.length == 0 || pos>=preorder.length) return null;
		TreeNode root = new TreeNode(preorder[pos]); //pos指向树根的位置
		int pivot = find(inorder,preorder[pos]); //根据树根将中序遍历分成两半
		int[] left = Arrays.copyOfRange(inorder, 0, pivot);//左半部分
		int[] right = Arrays.copyOfRange(inorder, pivot+1,inorder.length);//右半部分
		root.left = generate(preorder,left,pos+1);
		root.right = generate(preorder,right,pos+pivot+1);
		return root;
	}
	
	public int find(int[] array,int key){
		for(int i=0;i<array.length;i++)
			if(array[i]==key) return i;
		return -1;
	}
	
	public int find(int[] array,int start,int end, int key){
		for(int i=start;i<=end;i++)
			if(array[i]==key) return i;
		return -1;
	}
}
