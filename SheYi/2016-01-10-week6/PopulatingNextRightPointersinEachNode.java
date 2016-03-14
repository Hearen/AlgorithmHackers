package algorithm;

public class PopulatingNextRightPointersinEachNode {
	//I AC 0ms
/*	   public void connect(TreeLinkNode root) {
		   if(root==null) return ;
	          if(root.left!=null){
	        	  root.left.next=root.right;
	        	  if(root.next==null)
	        		  root.right.next=null; 
	        	  else
	        		  root.right.next=root.next.left;
	          }
	          connect(root.left);
	          connect(root.right);
	          
	    }*/
	//II 
    public void connect(TreeLinkNode root) {
       if(root==null) return ;
       if(root.right!=null){
    	   if(root.next==null){
    		   root.right.next=null;
    	   }else{
    		  root.right.next=getNextNode(root);
    	   }
    	   connect(root.right);
       }
       if(root.left!=null){
    	  if(root.right!=null){
    		  root.left.next=root.right;
    	  }else{
    		  root.left.next=getNextNode(root);
    	  }
    	  connect(root.left);
       }
         
    }
    
    public TreeLinkNode getNextNode(TreeLinkNode cur){
    	 TreeLinkNode temp=null;
    	 temp=cur.next;
    	while(temp!=null){
    		if(temp.left!=null) return temp.left;
    		else if(temp.right!=null) return temp.right;
    		else{
    			temp=temp.next;
    		}
    	}
    	return null;
    }
}
