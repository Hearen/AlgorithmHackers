/*package algorithm;

import java.util.ArrayList;
import java.util.List;
//N_Queens I
public class NQueens {
	    public List<List<String>> solveNQueens(int n) {
	        ArrayList<List<String>> result=new ArrayList<List<String>>();
	        int[] a=new int[n];
	        traceback(a,-1,n,result);
	         System.out.println("[");
		     for(int i=0;i<result.size();i++){
		       System.out.print("[");
		       for(int j=0;j<result.get(i).size();j++){
		    	   System.out.print(result.get(i).get(j));
		    	  if(j!=result.get(i).size()-1)
		    	   System.out.println(",");
		       }
		       if(i!=result.size()-1)
		       System.out.println("],");
		       else
		    	   System.out.println("]");
		     }
		     System.out.println("]");
		     System.out.println(n+"皇后问题，共有"+result.size()+"个解");
	        return result;
	    }
	    
	    public void traceback(int[] a,int k,int n,ArrayList<List<String>> r){
	         List<String> list=new ArrayList<String>();
	         int[] c=new int[n]; //存储每轮的候选集
	         int count=0;  //每轮候选的个数
	    	if(k==(n-1)){
	            for(int i=0;i<n;i++){
	            	 String temp="";
	              for(int j=0;j<n;j++){
	            	  if(a[i]==j) temp+="Q";
	            	  else temp+=".";
	              }
	              list.add(temp);
	            }
	            r.add(list);
	        }
	    	else if(k<n-1){
	    		k=k+1;
	    		count=construct_candidate(a,k,n,c);
	    		for(int i=0;i<count;i++){
	    			a[k]=c[i];
	    			traceback(a,k,n,r);
	    		}k=k-1;
	    	}
	    
	    }
      public int construct_candidate(int[] a,int k,int n,int[] c){
    	  int count=0;
    	  for(int i=0;i<n;i++){
    		 if(!conflict(a,k,i))
    			 c[count++]=i;
    	  }
    	  return count;
      }
      
      public boolean conflict(int[] a,int k,int index){
    	   for(int j=0;j<k;j++){
    		   if(a[j]==index||Math.abs(k-j)==Math.abs(index-a[j]))
    			   return true;
    	   }
    	   return false;
      }
      
      public static void main(String[] args){
    	  NQueens nqueues=new NQueens();
    	  nqueues.solveNQueens(8);
      }
}
*/

package algorithm;

import java.util.ArrayList;
import java.util.List;
//N_Queens II
public class NQueens {
	 public int totalNQueens(int n) {
	       // ArrayList<List<String>> result=new ArrayList<List<String>>();
	        int[] a=new int[n];
	        int[] result=new int[1];
	        traceback(a,-1,n,result);
	        /* System.out.println("[");
		     for(int i=0;i<result.size();i++){
		       System.out.print("[");
		       for(int j=0;j<result.get(i).size();j++){
		    	   System.out.print(result.get(i).get(j));
		    	  if(j!=result.get(i).size()-1)
		    	   System.out.println(",");
		       }
		       if(i!=result.size()-1)
		       System.out.println("],");
		       else
		    	   System.out.println("]");
		     }
		     System.out.println("]");*/
		     System.out.println(n+"皇后问题，共有"+result[0]+"个解");
	        return result[0];
	    }
	    
	    public void traceback(int[] a,int k,int n,int[] r){
	         List<String> list=new ArrayList<String>();
	         int[] c=new int[n]; //存储每轮的候选集
	         int count=0;  //每轮候选的个数
	    	if(k==(n-1)){
	             r[0]++;
	        }
	    	else if(k<n-1){
	    		k=k+1;
	    		count=construct_candidate(a,k,n,c);
	    		for(int i=0;i<count;i++){
	    			a[k]=c[i];
	    			traceback(a,k,n,r);
	    		}k=k-1;
	    	}
	    
	    }
      public int construct_candidate(int[] a,int k,int n,int[] c){
    	  int count=0;
    	  for(int i=0;i<n;i++){
    		 if(!conflict(a,k,i))
    			 c[count++]=i;
    	  }
    	  return count;
      }
      
      public boolean conflict(int[] a,int k,int index){
    	   for(int j=0;j<k;j++){
    		   if(a[j]==index||Math.abs(k-j)==Math.abs(index-a[j]))
    			   return true;
    	   }
    	   return false;
      }
      
      public static void main(String[] args){
    	  NQueens nqueues=new NQueens();
    	  nqueues.totalNQueens(20);
      }
}
