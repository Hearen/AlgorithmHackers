package week8;

public class UniquePathsII {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	      int m=obstacleGrid.length;
	      int n=obstacleGrid[0].length;
	      int[][] p=new int[m+1][n+1];
	      //≥ı ºªØ 
	      boolean flag=true;
	      for(int i=0;i<m;i++){
	    	  if(!flag){
	    		  p[i+1][1]=0;continue;
	    	  }
	    	  if(obstacleGrid[i][0]==1){
	    	    p[i+1][1]=0;
	    	      flag=false;
	    	  }
	    	  else
	    		  p[i+1][1]=1;
	      }
	      flag=true;
	      for(int j=0;j<n;j++){
	    	  if(!flag){
	    		 p[1][j+1]=0;continue;
	    	  }
	    	  if(obstacleGrid[0][j]==1){
	    		  p[1][j+1]=0;
	    		  flag=false;
	    	  }
	    	  else
	    		  p[1][j+1]=1;
	      }
	      
	      for(int i=2;i<m+1;i++){
	    	  for(int j=2;j<n+1;j++){
	    		  if(obstacleGrid[i-1][j-1]==1)
	    			  p[i][j]=0;
	    		  else
	    			  p[i][j]=p[i-1][j]+p[i][j-1];
	    	  }
	    	 
	      }
		       
		 return p[m][n];
	    }
	 
	 public static void main(String [] args){
		 UniquePathsII u=new UniquePathsII();
		 int[][] obstacleGrid={{1,0}};
		int r= u.uniquePathsWithObstacles(obstacleGrid);
	     System.out.println("result="+r);
	 }
}
