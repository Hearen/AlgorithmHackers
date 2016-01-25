package week7;

import java.util.LinkedList;
import java.util.List;

public class CountRightSmaller315 {
	public TreeNode root;
	public class TreeNode{
		int val;
		int children;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {val = x;children = 0;}
	}
	//偏左的BST，children 表示当前节点的孩子数。
	/**
	 * @param value
	 * @return 返回比新插入数小的元素个数
	 * @author xpxstar@gmail.com
	 * @2016年1月12日
	 * 时间复杂度O(lgN)
	 */
	public int  addNode(int value){
		int num = 0;
        if(this.root == null){
            this.root = new TreeNode(value);
            return num;
        }
        TreeNode parent = null, node = root;
        while(node != null){
        	parent = node;
        	node.children++;
            if(value > node.val){
            	num+= node.left == null?1:node.left.children+2;
            	node = node.right;
            }else{
            	node = node.left;
            }
        }
        /* Have found the new node's position. Insert it into the tree. */
        if(value > parent.val)
            parent.right = new TreeNode(value);
        else
            parent.left = new TreeNode(value);
        
        return num;
    }
	
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月12日
	 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
	 */
	public List<Integer> countSmaller(int[] nums) {
		/*思路：构建BST树，目的是在log(N)的时间内寻找到比已知数小的数的个数。
		 * 为此，该BST树有所修改，1)BST允许重复，且偏左的（即相等的数放在左子树）
		 * 2)存在children 记录当前节点的孩子个数
		 * 这样，当插入新数时，判断的路径上进行孩子个数更新，并且，每当向右查找时，累计当前根的左子树的孩子数目（即当前分支比目标小的个数）
		 * 找到新插入数的同时也将比目标数小的个数计算出来。
		 */
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (0> nums.length) {
			return result;
		}
		for (int i = nums.length-1; i > -1; i--) {
			result.addFirst(addNode(nums[i]));
		}
        return result;
    }
	public static void main(String[] args) {
		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,32,78,9,21,84,66,65};
		CountRightSmaller315 cr = new CountRightSmaller315();
		System.out.println(cr.countSmaller(nums));
	}

}
