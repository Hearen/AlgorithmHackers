package algorithm;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder==null||preorder.length==0) return null;
	        else if(preorder.length==1){
	          TreeNode head=new TreeNode(preorder[0]);
	            return head;
	        }else{
	        	TreeNode head=new TreeNode(preorder[0]);
	        	int middle=-1;
	            for(int i=0;i<inorder.length;i++){
	        	if(inorder[i]==head.val){
	        		middle=i; break;
	        	}
	        }
	        
	        head.left=buildTree(subset(preorder,1,middle),subset(inorder,0,middle-1));
	        head.right=buildTree(subset(preorder,middle+1,preorder.length-1),subset(inorder,middle+1,inorder.length-1));
	        return head;
	        }
	    }
	 public int[] subset(int [] old,int start,int end){
		 if(start>end) return null;
		   int[] result=new int[end-start+1];
		   int j=0;
		   for(int i=start;i<end+1;i++){
			   result[j++]=old[i];
		   }
		   return result;
	 }
	 
	 public void  preVisitedTree(TreeNode t){
		   if(t==null) return ;
		   preVisitedTree(t.left);
		   System.out.println(t.val);
		   preVisitedTree(t.right);
	   }
	 
	 public static void main(String [] args){
		 ConstructBinaryTreefromPreorderandInorderTraversal s=new ConstructBinaryTreefromPreorderandInorderTraversal();
		 int[] preorder={1,2,4,5,3,6,7};
		 int[] inorder={4,2,5,1,6,3,7};
		 TreeNode t;
		 t=s.buildTree(preorder, inorder);
		 s.preVisitedTree(t);
	 }
}
