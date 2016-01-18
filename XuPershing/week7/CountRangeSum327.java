package week7;

public class CountRangeSum327 {
	public TreeNode root;
	public class TreeNode{
		long val;
		int children;
		TreeNode left;
		TreeNode right;
		public TreeNode(long x) {val = x;children = 0;}
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
	public void  addNode(long value){
		if(this.root == null){
            this.root = new TreeNode(value);
            return;
        }
        TreeNode parent = null, node = root;
        while(node != null){
        	parent = node;
        	node.children++;
            if(value > node.val){
            	node = node.right;
            	}
            else{
            	node = node.left;
            }
        }
        if(value > parent.val)
            parent.right = new TreeNode(value);
        else
            parent.left = new TreeNode(value);
    }
	/**
	 * @param bottom
	 * @param top
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月18日
	 * 查找给定上下限范围内的数
	 * 首先找比下限小的个数
	 * 再找比上限高的个数
	 * 搜索两遍，时间复杂度是O(lgN)
	 */
	public int searchBetween(long bottom,long top){
		/* 思路：已经建好了BST
		 * 那么找比bottom小的个数时，只要判断当前节点是否比bottom小，
		 * 如果是，说明当前节点以及当前节点的左孩子都将比bottom小，计数也就需要加上当前节点、当前节点的左子树，以及左子树的孩子个数
		 * 当然，如果当前节点没有左子树，只需要计数加上当前节点就行。
		 * 如果当前节点要大，那么继续搜索左子树。
		 * 
		 */
		int num = 0;
        TreeNode node = root;
        while(node != null){
        	 if(bottom > node.val){
            	num+= node.left == null?1:node.left.children+2;
            	node = node.right;
            }else{
            	node = node.left;
            }
        }
        node = root;
        while(node != null){
        	 if(top < node.val){
            	num+= node.right == null?1:node.right.children+2;
            	node = node.left;
            }else{
            	node = node.right;
            }
        }
        return num;
    }
	/**
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016年1月12日
	 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
	 */
	public int countRangeSum(int[] nums, int lower, int upper) {
		/*思路：问题转化，记sum[i],是0~i的子数组和，那么某子数组 i~j的和(不包括i)就可以表示为sum[j]-sum[i]。
		 * 这样，我如果得到了sum[j],如果知道了j前面的某sum[i]，满足 lower <=sum[j]-sum[i] <= upper
		 * 也就是说，j前面存在sum[i] 大于等于 sum[j]-upper 且小于等于sum[j]-lower 就是找到了i~j(不包括i)的和符合范围。
		 * 用BST 用法和Count315相同。
		 */
		int size = nums.length;
		if (1>size) {
			return size;
		}
	     int count = 0;
	     long sum = 0;
	     for(int i = 0;i<nums.length;i++){
	    		addNode(sum);
				sum+= nums[i];
				count+=i+1-searchBetween(sum-upper, sum-lower);
			}
	     return count;
	}
	public int countRangeSumAb(int[] nums, int lower, int upper) {
		long sum = 0;
		int count = 0;
	     for(int i = 0;i<nums.length;i++){
	    	 sum = 0;
	    	 for (int j = i;j < nums.length; j++) {
	    		sum += nums[j];
				if (sum>=lower && sum <= upper) {
					count++;
				}
			}
	     }
	     return count;
	}
	public static void main(String[] args) {
		CountRangeSum327 cr = new CountRangeSum327();
		int[] nums = {2147483647,-2147483648,-1,0};
		System.out.println(cr.countRangeSum(nums, -1, 0));
	}
}
