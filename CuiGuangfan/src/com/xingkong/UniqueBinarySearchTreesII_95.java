package com.xingkong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月5日 上午9:33:28 class description
 */
public class UniqueBinarySearchTreesII_95 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	public List<TreeNode> generateTrees(int n) {
		if(n==0) {
			return new ArrayList<TreeNode>();
		}
//		if(n==1){
//			List<TreeNode> temp=new ArrayList<TreeNode>();
//			temp.add(new TreeNode(1));
//			return temp;
//		}
		return generate(1,n);//1-n共n个元素
        
    }
	private List<TreeNode> generate(int start,int end){
		List<TreeNode> result=new ArrayList<TreeNode>();
		if(start>end) {
			result.add(null);
			return result;
		}
		for(int separate=start;separate<=end;separate++){
			List<TreeNode> left=generate(start,separate-1);
			List<TreeNode> right=generate(separate+1,end);
			for(TreeNode leftTemp:left){
				for(TreeNode rightTemp:right){
					TreeNode tn=new TreeNode(separate);
					tn.left=leftTemp;
					tn.right=rightTemp;
					result.add(tn);
				}
			}
		}
		return result;
	}
	public static void main(String[]args){
		UniqueBinarySearchTreesII_95 ubs=new UniqueBinarySearchTreesII_95();
		System.out.println(ubs.generateTrees(1));
	}
}
