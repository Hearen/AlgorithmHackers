package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
    	if(board.length==0) return;
    	if(board[0].length==0) return;
         List<Point> opoints=new ArrayList<Point>();   
   	     List<Point> curList=new ArrayList<Point>();
   	     Boolean[][] visited =  new Boolean[board.length][board[0].length];
         for(int i=0;i<board.length;i++){
        	 for(int j=0;j<board[0].length;j++){
        		 if((i==0||(i==board.length-1)||j==0||j==(board[0].length-1))&&board[i][j]=='O')
        			 opoints.add(new Point(i,j));
        		 visited[i][j]=new Boolean(false);
        	 }
         }
        while(!opoints.isEmpty()){ 
        bfs(board,opoints.get(0),visited,opoints,curList);
        for(int i=0;i<curList.size();i++){
        	for(int j=0;j<opoints.size();j++)
        	if((opoints.get(j).x==curList.get(i).x)&&(opoints.get(j).y==curList.get(i).y))
        		opoints.remove(opoints.get(j));
        	board[curList.get(i).x][curList.get(i).y]='P';
           }
            curList.clear();
        }
       
        for(int i=0;i<board.length;i++){
       	 for(int j=0;j<board[0].length;j++){
       		 if(board[i][j]=='P')
       		   board[i][j]='O';
       		 else 
       			board[i][j]='X';
       	 }
        }
    }
    
    public class Point{
    	int x;
    	int y;
    	public Point(int x,int y){
    		this.x=x;
    		this.y=y;
    	}
    }
    public boolean bfs(char[][] board,Point p,Boolean[][] visited,List<Point> pList,List<Point> curList){
    	  boolean r=false;
    	  Queue<Point> queue = new LinkedList<Point>();  
    	  Point [] dps={new Point(-1,0),new Point(0,1),new Point(1,0),new Point(0,-1)};
    	  int x,y;
    	  visited[p.x][p.y]=true;
    	  curList.add(p);
    	//  pList.remove(p);
    	  queue.offer(p);
    	  while(!queue.isEmpty()){
    		  Point curPoint=queue.poll();
    		  for(int i=0;i<4;i++){
    			  x=curPoint.x+dps[i].x;
    			  y=curPoint.y+dps[i].y;
    			 if(x>=0&&
    				x<=board.length-1&&
    				y>=0&&
    				y<=board[0].length-1){
    				 if(!visited[x][y]){
    				 if(board[x][y]=='O'){
    					 Point temp=new Point(x,y);
    					 queue.offer(temp);
    					 curList.add(temp);
    					// pList.remove(temp);
    				 }
    				 visited[x][y]=true;
    				 }
    			 }
    		  }
    	  }
    	  return r;
    }
    
    public static void main(String [] args){
    	SurroundedRegions s=new SurroundedRegions();
    	/*char board[][]={{'x','x','x','x'},
    			        {'x','o','o','x'},
    			        {'x','x','o','x'},
    			        {'o','o','x','x'},
    	               };*/
    	char board[][]={{'X','O','X'},
		                {'O','X','O'},
		                {'X','O','X'},
               };            
    	s.solve(board);
    	
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			System.out.print(board[i][j]+",");
    		}
    		System.out.println("");
    	}
    }
}
