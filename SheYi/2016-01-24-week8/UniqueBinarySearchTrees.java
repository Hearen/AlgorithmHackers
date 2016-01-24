package week8;

public class UniqueBinarySearchTrees {
	//AC 0ms  s[i]表示1到i可以构成的唯一二叉搜索树的个数 这依次遍历每一个数，左边的数为左子树，右边的数为右子树 把所有情况加起来 
	//动态规划的思想 分解为子问题求解
	public int numTrees(int n) {
		 int[] s=new int[n+1];
        s[0]=1;
        s[1]=1;
	     for(int i=2;i<=n;i++){
	    	  int temp=0;
	    	 for(int j=1;j<=i;j++){
	    	  temp+=s[j-1]*s[i-j];
	    	 }
	    	 s[i]=temp;
	     }
	     return s[n];
	 }
}
