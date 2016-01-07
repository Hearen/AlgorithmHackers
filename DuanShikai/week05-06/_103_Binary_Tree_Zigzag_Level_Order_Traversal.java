package com.sky.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年1月6日 下午1:31:42
 * @content 
 */

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root!=null){
        	boolean flag=true; //当为true时，表示从左往右遍历，当为false时，表示从右往左遍历
            Queue<TreeNode> queue=new LinkedList<TreeNode>();queue.add(root);
            int size=0; TreeNode curr;
            while(!queue.isEmpty()){
            	List<Integer> list = new ArrayList<Integer>();
            	size = queue.size();
            	for(int k=0;k<size;k++){
            		curr = queue.poll();
            		if(flag) list.add(curr.val);
            		else list.add(0,curr.val);
            		if(curr.left!=null) queue.add(curr.left);
            		if(curr.right!=null) queue.add(curr.right);
            	}
            	result.add(list);
            	flag= flag==true ? false : true;
            }
        }
        return result;
    }
}
