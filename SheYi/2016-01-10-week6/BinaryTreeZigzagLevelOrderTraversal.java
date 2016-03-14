package algorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	//用队列的解法
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> rList=new ArrayList<List<Integer>>();
       Queue<TreeNode> qtree=new LinkedList<TreeNode>();
       HashMap<TreeNode,Integer> map=new HashMap<TreeNode,Integer>();
       List<Integer> tempList=new ArrayList<Integer>();
       int level=0; //节点的层次
       if(root==null) return rList;
       qtree.offer(root);  //root节点如队列，初始化队列
       map.put(root, 0);
      // tempList.add(root.val);  
       TreeNode temp=null;
       while(!qtree.isEmpty()){
    	   temp=qtree.poll(); 
    	   if(!map.get(temp).equals(level)){
    		   if(level%2==0)
    	         rList.add(tempList);
    		   else{
    			   reverseList(tempList);
    			   rList.add(tempList);   
    		   }
    		   tempList=new ArrayList<Integer>();
    		   level++;
    	   }
    	   tempList.add(temp.val);    //遍历到某个节点，再访问该节点的数据
    	   if(null!=temp.left) {
    		    qtree.offer(temp.left);
    		    map.put(temp.left, map.get(temp)+1);
    		    //tempList.add(temp.left.val); //buy
    	   }
    	   if(null!=temp.right) {
    		   qtree.offer(temp.right);
    		   map.put(temp.right,map.get(temp)+1);
    		  // tempList.add(temp.right.val);
    	   }
    	   
    	   if(qtree.isEmpty()){   //处理最后一层
    		   if(level%2==0)
      	         rList.add(tempList);
      		   else{
      			   reverseList(tempList);
      			   rList.add(tempList);   
      		   }
    	   }
       }
   /*    System.out.println("[");
      for(int i=0;i<rList.size();i++){
    	  System.out.print("	[");
    	  for(int j=0;j<rList.get(i).size();j++){
    		  System.out.print(rList.get(i).get(j)+" ");
    	  }
    	  System.out.println("]	");
      }
      System.out.println("]");*/
       return rList;
	   
    }
  
    public void reverseList(List<Integer> list){
    	Stack<Integer>  stack=new Stack<Integer>();
        for(int i=0;i<list.size();i++){
        	stack.add(list.get(i));
        }
        list.clear();
        while(!stack.isEmpty()){
        	list.add(stack.pop());
        }
    }
    
    public static void main(String [] agrs){
    	BinaryTreeZigzagLevelOrderTraversal bs=new BinaryTreeZigzagLevelOrderTraversal();
    	TreeNode root=new TreeNode(1);
    	TreeNode node1=new TreeNode(2);
    	TreeNode node2=new TreeNode(3);
    	TreeNode node3=new TreeNode(4);
    	TreeNode node4=new TreeNode(5);
    	TreeNode node5=new TreeNode(6);
    	TreeNode node6=new TreeNode(7);
    	root.left=node1;
    	root.right=node2;
    	node1.left=null;
    	node1.right=node3;
    	node2.left=node4;
    	node2.right=node5;
    	node3.left=null;
    	node4.right=node6;
    	bs.zigzagLevelOrder(root);
    }
}


//双栈的解法
/*import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	 List<List<Integer>> rList=new ArrayList<List<Integer>>();
    	 Stack<TreeNode> stack0=new Stack<TreeNode>();
    	 Stack<TreeNode> stack1=new Stack<TreeNode>();
    	 List<Integer> tempList=new ArrayList<Integer>();	
    	 TreeNode tempNode=null;
    	 if(root==null) return rList;
    	 stack0.push(root);
    	 while(!stack0.isEmpty()||!stack1.isEmpty()){ 
    	 while(!stack0.isEmpty()){
    		 tempNode=stack0.pop();
    		 tempList.add(tempNode.val);
    		 if(null!=tempNode.left){
    			 stack1.push(tempNode.left);
    			// tempList.add(tempNode.left.val);
    		 }
    		 if(null!=tempNode.right){
    			 stack1.push(tempNode.right);
    			// tempList.add(tempNode.right.val);
    		 }
    	 }
    	 if(!tempList.isEmpty())
    		 rList.add(tempList);
    	  tempList=new ArrayList<Integer>();
    	 while(!stack1.isEmpty()){
    		 tempNode=stack1.pop();
    		 tempList.add(tempNode.val);
    		 if(null!=tempNode.right){
    			 stack0.push(tempNode.right);
    			 //tempList.add(tempNode.right.val);
    		 }
    		 if(null!=tempNode.left){
    			 stack0.push(tempNode.left);
    			// tempList.add(tempNode.left.val);
    		 }
    	 }
    	 if(!tempList.isEmpty())
    	 rList.add(tempList);
    	 tempList=new ArrayList<Integer>();
    	 }
    	 
    	   System.out.println("[");
    	      for(int i=0;i<rList.size();i++){
    	    	  System.out.print("	[");
    	    	  for(int j=0;j<rList.get(i).size();j++){
    	    		  System.out.print(rList.get(i).get(j)+" ");
    	    	  }
    	    	  System.out.println("]	");
    	      }
    	      System.out.println("]");
    	 return rList;
    }
    public static void main(String [] agrs){
    	BinaryTreeZigzagLevelOrderTraversal bs=new BinaryTreeZigzagLevelOrderTraversal();
    	TreeNode root=new TreeNode(1);
    	TreeNode node1=new TreeNode(2);
    	TreeNode node2=new TreeNode(3);
    	TreeNode node3=new TreeNode(4);
    	TreeNode node4=new TreeNode(5);
    	TreeNode node5=new TreeNode(6);
    	TreeNode node6=new TreeNode(7);
    	root.left=node1;
    	root.right=node2;
    	node1.left=null;
    	node1.right=node3;
    	node2.left=node4;
    	node2.right=node5;
    	node3.left=null;
    	node4.right=node6;
    	bs.zigzagLevelOrder(root);
    }
}*/