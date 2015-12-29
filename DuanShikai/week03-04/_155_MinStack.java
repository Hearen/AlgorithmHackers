package com.sky.leetcode;


/**
 * @author DuanSky
 * @date 2015年12月16日 下午9:00:31
 * @content 
 */

public class _155_MinStack{
	
	public static void main(String args[]){
		_155_MinStack minStack=new _155_MinStack();
		minStack.push(-10);
		minStack.push(14);
		minStack.getMin();
		minStack.getMin();
		minStack.push(-20);
		minStack.getMin();
		minStack.getMin();
		minStack.top();
		minStack.getMin();
		minStack.pop();
		minStack.push(10);
		minStack.push(-7);
		minStack.getMin();
		minStack.push(-7);
		minStack.pop();
		minStack.top();
		minStack.getMin();
		minStack.pop();
	}
	
	private Node top;
	
	public void push(int x) {
        if(top==null)
        	top=new Node(x,x);
        else{
        	Node newNode=new Node(x,Math.min(getMin(),x));
        	top.forward=newNode;
        	newNode.back=top;
        	top=newNode;
        }
        
    }

    public void pop() {
        if(top!=null){
        	top=top.back;
        	if(top!=null){
        		top.forward.back=null;
        		top.forward=null;
        	}
        }
    }

    public int top() {
       return top!=null ? top.x : 0;
    }

    public int getMin() {
    	return top!=null ? top.min : 0;
    }
    
    class Node{
    	private int x;
    	private int min;
    	public Node back;
    	public Node forward;
    	Node(int x,int min){
    		this.x=x;
    		this.min=min;
    	}
    }
}
