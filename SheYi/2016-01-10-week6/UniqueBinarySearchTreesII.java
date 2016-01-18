package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTreesII {
	/* public List<TreeNode> generateTrees(int n) {
	        List<TreeNode> nodelist=new ArrayList<TreeNode>();
	        HashMap<Integer,Integer> s=new HashMap<Integer,Integer>();
	        TreeNode temp=null;
	        for(int i=1;i<n+1;i++){
	          temp=new TreeNode(i);
	          TreeNode r=temp;
	          s.put(i, i);
	          traceback(1,n,s,temp,null,nodelist,r);
	          s.remove(i);
	        }
	        return nodelist;
	    }
	 
	 public void traceback(int k,int n,HashMap<Integer,Integer> s,TreeNode curNode,TreeNode preNode,List<TreeNode> rlist,TreeNode r){
		 if(k==n){
			 TreeNode temp=copyTree(r);
		     rlist.add(temp);
		    // s.clear();
		 }else{
			 List<Integer> c=new ArrayList<Integer>();
			 if(!c.isEmpty()) c.clear();
			 construct_candidate(n,0,curNode,preNode,s,c);
			 for(int i=0;i<c.size();i++){
				 curNode.left=new TreeNode(c.get(i));
				 s.put(c.get(i), c.get(i));
				 k++;
				 traceback(k,n,s,curNode.left,curNode,rlist,r); 
				 k--;
				 s.remove(c.get(i));
				 curNode.left=null;
			 }
			  if(!c.isEmpty()) c.clear();
			 construct_candidate(n,1,curNode,preNode,s,c);
			 for(int i=0;i<c.size();i++){
				 curNode.right=new TreeNode(c.get(i));
				 s.put(c.get(i), c.get(i));
				 k++;
				 traceback(k,n,s,curNode.right,curNode,rlist,r);
				 k--;
				 s.remove(c.get(i));
				 curNode.right=null;
			 }
		 }
	 }
	 public void construct_candidate(int n,int type,TreeNode node,TreeNode pre,HashMap<Integer,Integer> cur,List<Integer> c){
		if(pre==null) pre=new TreeNode(n+1);
		 if(type==0){
		 for(int i=1;i<pre.val;i++){
			  if(cur.containsKey(i))
				  continue;
			  else if(node.val>i)
				  c.add(i);
		  }
		 }else if(type==1){
			 for(int i=pre.val+1;i<n+1;i++){
				 if(cur.containsKey(i))
					  continue;
				 
				  else if(node.val<i)
					  c.add(i);
			 }
		 }
		 
	 }
	 
	 private TreeNode copyTree(TreeNode a){
		 if(a!=null){
		 TreeNode b=new TreeNode(a.val);
		 b.left=copyTree(a.left);
		 b.right=copyTree(a.right);
		    return b;
		 }else{
			 return null;
		 }
		 
	 }*/
	
	//II 这是网上的解法  纯递归的思想 非常好   把原问题分解成多个子问题 递归的求解子问题  最终得到解
	 public List<TreeNode> generateTrees(int n) {
		 if(n<1) return new ArrayList<TreeNode>();
		 else
	     return recur(1,n);
	    }
	 
	 public List<TreeNode> recur(int begin,int end){
		 List<TreeNode> rlist=new ArrayList<TreeNode>();
		 if(begin>end){
			 rlist.add(null);
			 return rlist;
		 }else{
			 for(int k=begin;k<=end;k++){
			 List<TreeNode> left=recur(begin,k-1);  //左子树 
			 List<TreeNode> right=recur(k+1,end);   //右子树
			for(int i=0;i<left.size();i++){
				for(int j=0;j<right.size();j++){
					TreeNode cur=new TreeNode(k);
					cur.left=left.get(i);
					cur.right=right.get(j);
					rlist.add(cur);	
				}
			}
			 }
			 return rlist;
		 }
		 
	 }
	 
	 
	 //I  用递归做会超时
	 public int numTrees(int n) {
         int temp=0;
	     if(n==0) return 1;
	     else if(n==1) return 1;
	     else if(n==2) return 2;
	     else {
	     for(int i=1;i<=n;i++){
	    	temp+=numTrees(i-1)*numTrees(n-i);
	     }
		 return temp;
	     }
	 }
	 //ac 0ms
	 public int numTrees1(int n) {
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
	  
	 //中根遍历
	 public void  preVisitedTree(TreeNode t){
		   if(t==null) return ;
		   preVisitedTree(t.left);
		   System.out.println(t.val);
		   preVisitedTree(t.right);
	   }
	 
	 public static void main(String[] args){
		 UniqueBinarySearchTreesII u=new UniqueBinarySearchTreesII();
		/* List<TreeNode> rlist=u.generateTrees(3);
		 for(int i=0;i<rlist.size();i++){
			u.preVisitedTree(rlist.get(i)); 
			System.out.println("第"+i+"组");
		 }*/
		 int r=u.numTrees1(19);
		 System.out.println("r="+r);
	 }
}
