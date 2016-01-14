import java.util.HashMap;
import java.util.Map;

/**
 * @author xpxstar@gmail.com
 *
 * 2016年1月11日
 * Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructFromPreIn105 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	private int preStart = 0;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		/*思路：中序遍历是关键
		 * 先序遍历的第一个数字是树的根，那么从中序表里找到根，左边即是左子树的中序遍历结果，右边是右子树的中序遍历
		 * 找到左右两边的根，即是第一个数字的左右孩子。
		 * 递归上述过程
		 * 使用了map来寻找根的中序下标。
		 * 时间和控件复杂度为O(n)
		 */
		if(preorder.length <1){
	        return null;
	    }
		Map<Integer, Integer> index = new HashMap<>();
		for (int i = 0;i<inorder.length;i++) {
			index.put(inorder[i],i);
		}
		return subTree(preorder, inorder, 0, inorder.length,index);
		
    }
	private TreeNode subTree(int[] preorder,int[] inorder,int inStart,int inEnd,Map index){
		if (inStart >= inEnd) {
			return null;
		}
		if (inStart == inEnd-1) {
			preStart++;
			return new TreeNode(inorder[inStart]);
		}
		TreeNode tn = new TreeNode(preorder[preStart]);
		int inmid = (int) index.get(preorder[preStart]);
		preStart++;
		tn.left = subTree(preorder, inorder,inStart,inmid,index);
		tn.right = subTree(preorder,inorder,inmid+1, inEnd,index);
		return tn;
	}
	public static void main(String[] args) {
		int[] pre ={1,2,4,8,5,9,10,3,6,7,11};
		int[] in = {8,4,2,9,5,10,1,6,3,7,11}; 
		ConstructFromPreIn cf = new ConstructFromPreIn();
		TreeNode tnn= cf.buildTree(pre,in);
		System.out.println("finish");
	}

}
