/**
 *关键点也都踩到了，只是在细节处理上不太优雅。
 *一方面对边界的处理过于繁琐，可以统一对越界的边界值进行判断，而不需要一条一条的判断；
 *另一方面，对于之前是否走过的字符，可以不需要申请新的空间进行判断；
* @author DuanSky
* @date 2015年12月4日 下午4:31:02
* @content 
*/
package com.sky.leetcode;

public class _079_WordSearch {
	
	public static void main(String args[]){
		char[][] board={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word="ABCB";
		System.out.println(exist(board,word));
	}

	public static boolean exist(char[][] board, String word) {
	    if(board==null || board.length==0 || word.length()==0)
	    	return false;
	    int hight=board.length;int length=board[0].length;
	    char[] array=word.toCharArray();
	    int[][] path=new int[hight][length];
	    boolean result=false;
	    for(int i=0;i<hight;i++){
	    	for(int j=0;j<length;j++){
	    		if(board[i][j]==array[0]){
	    			path[i][j]=1;
	    			result |= _exist(board,array,1,new int[]{i,j});
	    			path[i][j]=0;
	    		}
	    	}
	    }
	    return result;
	}
	
	
	/**
	 * 该算法采用回溯的思想，
	 * 关键在于
	 * 1.边界值如何处理？
	 * 2.如何记录某个字符之前已经遍历过。我采用的是新建一个数组path来表示该位置的字符是否之前遍历过
	 * @param board 字符板
	 * @param word 要查找的字符数组
	 * @param current 当前准备查找的字符的数组索引
	 * @param position 上一次字符出现的位置
	 * @param path 到目前为止字符的查找路径
	 * @return
	 */
	
	public static boolean _exist(char[][] board,char[] word,int current, int[] position){
		if(current==word.length)
			return true;
		if(position[0]<0 || position[0]==board.length || position[1]<0 || position[1]==board[0].length)
			return false;
		if(word[current] != board[position[0]][position[1]])
			return false;
		boolean result=false;
		board[position[0]][position[1]]^=256;
		result  |= _exist(board,word,current+1,new int[]{position[0]+1,position[1]})
				|| _exist(board,word,current+1,new int[]{position[0],position[1]+1})
				|| _exist(board,word,current+1,new int[]{position[0]-1,position[1]})
				|| _exist(board,word,current+1,new int[]{position[0],position[1]-1});
		board[position[0]][position[1]]^=256;
		return result;
	}
	
	public static boolean _exist_time_limited(char[][] board,char[] word, int current, int[] position, int[][] path){
		if(current==word.length){//目前为止，找到了word里所有的字符
			return true;
		}
		else{
			char c = word[current];//当前要查找的字符
			int x=position[0];int y=position[1];
			int hight=board.length; int length=board[0].length;
			boolean result=false;
			if(0<x && board[x-1][y]==c && path[x-1][y]!=1){
				path[x-1][y]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x-1,y},path);
				path[x-1][y]=0;
			}
			if(x<hight-1 && board[x+1][y]==c && path[x+1][y]!=1){
				path[x+1][y]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x+1,y},path);
				path[x+1][y]=0;
			}
			if(0<y && board[x][y-1]==c && path[x][y-1]!=1){
				path[x][y-1]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x,y-1},path);
				path[x][y-1]=0;
			}
			if(y<length-1 && board[x][y+1]==c && path[x][y+1]!=1){
				path[x][y+1]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x,y+1},path);
				path[x][y+1]=0;
			}
			return result;
		}
	}
}

