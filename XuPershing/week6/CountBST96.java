import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountBST96 {
	
	/**
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月11日
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
	 */
	public int numTrees(int n) {
		/*思路：经分析可发现总的个数即根节点依次为1、2、3..n时左右子树个数之积的 和
		 * 即a(n) = a(n-1)*a(0)+a(n-2)*a(1)+...+a(1)*a(n-2)+a(0)*a(n-1);
		 * 初始状态，a(0) = a(1) = 0;
		 */
		int nTree[] = new int[n+1];
		nTree[0] = 1;
		nTree[1] = 1;
        for (int i = 2; i <= n; i++) {
			 for (int j = 0; j < i; j++) {
				 nTree[i] +=nTree[i-j-1]*nTree[j];
			 }
		}
        return nTree[n];
    }
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public List<TreeNode> generateTrees(int n) {
		if (n<1) {
			return new ArrayList<TreeNode>();
		}
		
		Map<int[], String> m = new HashMap<>();
		List<List<TreeNode>> history = new ArrayList<>(n+1);
		List<TreeNode> n0 = new LinkedList<>();
		List<TreeNode> n1 = new LinkedList<>();
		n0.add(null);
		n1.add(new TreeNode(1));
		history.add(n0);
		history.add(n1);
		for (int i = 2; i <= n; i++) {
			List<TreeNode> tmp = new LinkedList<>();
			for (int j = 0; j < i; j++) {
				tmp.addAll(rootCase(history.get(j),j+1,history.get(i-j-1)));
			}
			history.add(tmp);
		}
		return history.get(n);
	}
	public List<TreeNode> rootCase(List<TreeNode> left,int root ,List<TreeNode> right){
		List<TreeNode> newN =  new LinkedList<>();
		for (TreeNode leftNode : left) {
			for (TreeNode rightNode : right) {
				TreeNode caseRoot = new TreeNode(root);
				caseRoot.left = leftNode;
				caseRoot.right = addGap(rightNode, root);
				newN.add(caseRoot);
			}
		}
		return newN;
	}
	
	public TreeNode addGap(TreeNode root ,int gap){
		if (null == root) {
			return null;
		}
		TreeNode tn = new TreeNode(root.val+gap);
		tn.left = addGap(root.left, gap);
		tn.right = addGap(root.right, gap);
		return tn;
	}
	public static void main(String[] args) {
//		CountBST96 cb = new CountBST96();
//		System.out.println(cb.generateTrees(3));
		int[] aa = {1,2,3};
		int[] bb = {1,2,3};
		System.out.println(aa.hashCode()+" "+bb.hashCode());
	}
}
