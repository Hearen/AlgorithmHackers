package algorithm;

import java.util.Random;

public class MergekSortedLists {

	 public ListNode mergeKLists(ListNode[] lists) {
	     if(lists.length==0) return null;
			 ListNode result=lists[0];
			 for(int i=1;i<lists.length;i++){
				result=merge2Lists(result,lists[i]);
			 }
			return result;
		        
		    }
		 
		 public ListNode merge2Lists(ListNode one,ListNode two){
			 ListNode temp;
			 ListNode nextNode;
			 ListNode preNode = null;
			 ListNode result=one;
			 if(null==two||null==one) return null;
			 		
			 while(null!=two){
	        	
	        	 if(null==one&&null!=preNode){
					 preNode.next=two;
					 break;
					 }

				 if(one.val<two.val){
					 preNode=one;
					 one=one.next;
				 }
				 else {
					 nextNode=two.next;
					 two.next=one;
					 if(null!=preNode)
					 preNode.next=two;
					 else 
						result=two;
	                 preNode=two;
					 two=nextNode;
				 }

				 
			 }
			   
		       return result;
		 }
		 
		 
		 
	 
	 public static void main(String [] arg){
		 MergekSortedLists ml = new MergekSortedLists();
		 ListNode one=new ListNode(0),two=new ListNode(0);
		 ListNode temOne=one;
		 ListNode temTwo=two;
		// Random r = new Random(100);
		 for(int i=0;i<10;i++){
			 one.val=i*2+1;
			 one.next=new ListNode(0);
			 one=one.next;
		 }
		 
		 for(int i=0;i<10;i++){
			 two.val=i*i+1;
			 two.next=new ListNode(0);
			 two=two.next;
		 }
		 
		 ListNode rlist=ml.merge2Lists(temOne, temTwo);
		 while(null!=rlist.next){
			 System.out.println(rlist.val);
			 rlist=rlist.next;
		 }
		
	 }
}
