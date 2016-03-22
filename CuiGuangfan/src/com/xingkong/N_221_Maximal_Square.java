package com.xingkong;

import java.util.Stack;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月9日 下午4:00:14 
* class description
*/
public class N_221_Maximal_Square {
	private static class Entity{
		int x;
		int y;
		public Entity(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	private static int recursion(char[][] matrix,int x,int y,Stack<Entity> stack,int count){
		//先检查基础的两个
		if(y+count>matrix[0].length-1||x+count>matrix.length-1||matrix[x][y+count]!='1'||matrix[x+count][y]!='1'){
			return count;
		}
		Stack<Entity> thisStack=new Stack<Entity>();
		//检查栈中的
		while(!stack.isEmpty()){
			Entity e=stack.pop();
			if(matrix[e.x+1][e.y+1]!='1'){
				return count;
			}
			thisStack.push(new Entity(e.x+1,e.y+1));
		}
		thisStack.push(new Entity(x,y+count));
		thisStack.push(new Entity(x+count,y));
		return recursion(matrix,x,y,thisStack,count+1);
	}
	public static int maximalSquare(char[][] matrix) {//53ms 1.22%
		int max=0;
		for(int i=0;i<matrix.length-max;i++)
			for(int j=0;j<matrix[i].length-max;j++){
				if(matrix[i][j]=='1'){
					Stack<Entity> stack=new Stack<Entity>();
					stack.push(new Entity(i,j));
					int tempMax=recursion(matrix,i,j,stack,1);
					if(tempMax>max){
						max=tempMax;
					}
				}
			}
        return max*max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_221_Maximal_Square.maximalSquare(new char[][]{
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','1'}
			}));
	}

}
