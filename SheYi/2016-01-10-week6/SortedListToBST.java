package algorithm;

public class SortedListToBST {
   public TreeNode sortedListToBST(ListNode head) {
          ListNode nex=null;
	   if(head==null)
		   return null;
	   else if(head.next==null){
        	return new TreeNode(head.val);
        }else if(head.next.next==null){
        	TreeNode h=new TreeNode(head.next.val);
        	TreeNode m=new TreeNode(head.val);
        	h.left=m;
        	return h;
        }else{
        	ListNode middle=getMiddleNode(head);
        	TreeNode rTreeNode=new TreeNode(middle.next.val);
        	nex=middle.next.next;
        	middle.next=null;
	       rTreeNode.left=sortedListToBST(head);
	       rTreeNode.right=sortedListToBST(nex);
           return rTreeNode;
        }
    }
   
   public ListNode getMiddleNode(ListNode head){
	   if(head==null||head.next==null) return head;
	   ListNode target=head;
	   ListNode temp=head;
	   ListNode pre=null;
	  while(temp!=null&&temp.next!=null){
		  pre=target;
		  target=target.next;
		  temp=temp.next.next;
	  }
	  return pre;
   }
  /* public void  preVisitedTree(TreeNode t){
	   if(t==null) return ;
	   preVisitedTree(t.left);
	   System.out.println(t.val);
	   preVisitedTree(t.right);
   }
   public static void main(String [] args){
	   SortedListToBST s=new SortedListToBST();
	   ListNode head=new ListNode(1);
	   ListNode temp=head;
	   for(int i=2;i<10;i++){
	   head=head.next=new ListNode(i);
	   }
	   TreeNode r;
	   r=s.sortedListToBST(temp);
	   s.preVisitedTree(r);
   }*/
}
