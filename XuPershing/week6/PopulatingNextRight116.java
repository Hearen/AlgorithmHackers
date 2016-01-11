import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRight116 {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
		public void setChildren(TreeLinkNode l,TreeLinkNode r){
			left = l;
			right = r;
		}
		public void setVal(int x){
			val = x;
		}
	}
	 /**
	 * @param root
	 * @author xpxstar@gmail.com
	 * @2016年1月5日
	 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
	 */
	public void connect(TreeLinkNode root) {
	    if (root == null ||root.left == null) {
			return;
		}
	    root.left.next = root.right;
	    if (root.next != null) {
			root.right.next = root.next.left;
		}
	    connect(root.left);
	    connect(root.right);
    }
	/**
	 * @param root
	 * @author xpxstar@gmail.com
	 * @2016年1月7日
	 * what if it is not a perfect binary tree?
	 */
	public void connectII(TreeLinkNode root) {
		/*思路：从上到下，从左至右遍历
		 * 保存一个当前层次最右的指针，当遇到同层的，即将该指针指向当前
		 */
		List<TreeLinkNode> head = new ArrayList<>();
		link(root,head,0);
	}
	private void link(TreeLinkNode now,List<TreeLinkNode> head,int level){
		if (now == null) {
			return;
		}
		if (head.size() <= level) {
			head.add(now);
		}
		head.get(level).next = head.get(level) == now?null:now;
		head.set(level, now);
		link(now.left, head, level+1);
		link(now.right, head, level+1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRight116 pn = new PopulatingNextRight116();
		TreeLinkNode init[] = new TreeLinkNode[7];
		for (int i = 1; i < 8; i++) {
			init[i-1] = pn.new TreeLinkNode(i);
		}
		init[0].setChildren(init[1], init[2]);
		init[1].setChildren(init[3], init[4]);
		init[2].setChildren(init[5], init[6]);
		pn.connectII(init[0]);
		System.out.println("finish");
	}
}
