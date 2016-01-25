package week8;

public class DistinctSubsequences {
	 public int numDistinct(String s, String t) {
		   int sLength=s.length();
		   int tLength=t.length();
		   if(s.equals(t)) return 1;
		   if(sLength==0||tLength==0) return 0;
		   int[][] d=new int[sLength][tLength];
		   int count=0;
		   for(int i=0;i<sLength;i++){
			   if(s.charAt(i)==t.charAt(0)){
				   count++;
			   }
			   d[i][0]=count;
		   }
		   for(int i=1;i<tLength;i++){
			   d[0][i]=0;
		   }
		   for(int i=1;i<sLength;i++){
			   for(int j=1;j<tLength;j++){
				   if(s.charAt(i)==t.charAt(j))
				       d[i][j]=d[i-1][j-1]+d[i-1][j];
				   else
					   d[i][j]=d[i-1][j];
			   }
		   }
	        return d[sLength-1][tLength-1];
	    }
	 
	 public static void main(String [] args){
		 DistinctSubsequences d=new DistinctSubsequences();
		 int r=d.numDistinct("aabab", "ab");
		 System.out.println("result="+r);
	 }
}
