package week7;

public class BSTree {
	public TreeNode root;
	public class TreeNode{
		int val;
		int children;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {val = x;children = 0;}
		public TreeNode(TreeNode l,TreeNode r) {left = l;right = r;}
	}
	//偏左的BST，children 表示当前节点的孩子数。
	/**
	 * @param value
	 * @return 返回比当前值小的元素个数。
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
	
	public static void main(String[] args) {
		BSTree tree = new BSTree();
        tree.addNode(25);
        tree.addNode(1);
        tree.addNode(65);
        tree.addNode(9);
        tree.addNode(41);
        tree.addNode(8);
        System.out.println(tree.addNode(0));
        
        
	}

}
