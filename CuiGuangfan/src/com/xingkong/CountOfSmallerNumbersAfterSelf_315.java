package com.xingkong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月14日 上午8:46:46 class description
 */
public class CountOfSmallerNumbersAfterSelf_315 {
	private static class TreeNode {
		TreeNode left;
		TreeNode right;
		int thisCount=1;
		int value;
		int leftCount;

		TreeNode(int value) {
			this.value = value;
		}

	}
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> returnList=new ArrayList<Integer>();
		if(nums.length==0) return returnList;
		returnList.add(0);
		TreeNode treeRoot = new TreeNode(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
			TreeNode currentRoot = treeRoot;
			Integer count=0;
			while (currentRoot!=null) {
				if (nums[i] > currentRoot.value) {
					count+=currentRoot.leftCount+currentRoot.thisCount;
					if (currentRoot.right != null) {
						currentRoot = currentRoot.right;
					} else {
						currentRoot.right = new TreeNode(nums[i]);
						break;
					}
				} else if(nums[i] < currentRoot.value){
					currentRoot.leftCount++;
					if (currentRoot.left != null) {
						currentRoot = currentRoot.left;
					} else {
						currentRoot.left = new TreeNode(nums[i]);
						break;
					}
				}else{
					count+=currentRoot.leftCount;
					currentRoot.thisCount++;
					break;
				}
			}
			returnList.add(count);
		}
		Collections.reverse(returnList);
		return returnList;
	}

	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf_315  csn=new CountOfSmallerNumbersAfterSelf_315();
		System.out.println(csn.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
	}

}
