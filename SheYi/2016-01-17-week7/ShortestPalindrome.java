package week7;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPalindrome {
/*	 public String shortestPalindrome(String s) {
		 if(s.length()<1) return s;
	       int index=0;
	       int rIndex=0;
		   for(int i=s.length()-1;i>0;i--){
			   if(s.charAt(0)==s.charAt(i)){
				   index=i;
				   break;
			   }
		   }
		   boolean flag=true;
		   while(index!=0){
			   flag=true;
			    int curIndex=index;
			    index=0;
			   for(int i=0,j=curIndex;i<j;i++,j--){
				   if(s.charAt(i)!=s.charAt(j)){
					  flag=false; break; 
				   }
			   }
			   if(flag){
				 rIndex=curIndex;  break;
			   }else{
				   for(int i=curIndex-1;i>0;i--){
					   if(s.charAt(0)==s.charAt(i)){
						   index=i;
						   break;
					   }
				   }
			   }
		   }
		   StringBuffer rs=new StringBuffer(s);
		   StringBuffer dif=new StringBuffer(s.substring(rIndex+1,s.length()));
		   return dif.reverse().toString()+rs.toString();
	    }*/
	
	//网上的解法，总体上的思路是把问题转化为求KMP算法next数组的问题
	//本题题意是在给定字符串前补充字符串，使其成为最短的回文串 ，其实就是要先找到从字符串开头字符开始的最长子回文串，然后把后面剩余的字符串转置加到前面
	//那最长子回文串怎么求呢？ 先求源字符串s的转置s_rev,然后将他们拼装成新字符串snew=s+“#”+s.rev，再求snew的next数组；
	//在KMP算法中，next数组表示，字符串最长的前缀后缀匹配长度，比如字符串“abcdabd”的next数组为{0，0，0，0，1，2，0}
	//字符串前后缀的定义：比如字符串“abcda”，的前缀有{"a","ab","abc","abcd"} ，而后缀为{"a","da","cda","bcda"}，所以最长公共前后缀为“a”，故
	//next数组的值为1，next数组在KMP算法中的作用是在发现第i个元素不匹配后，返回上一个与第i-1元素相同的元素，看下一个元素是否匹配，而不是直接回到字符串的开头
	 public String shortestPalindrome(String s) {
 	        StringBuilder builder = new StringBuilder(s);
	        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
	    }

	    private int getCommonLength(String str) {
	        StringBuilder builder = new StringBuilder(str);
	        String rev = new StringBuilder(str).reverse().toString();
	        builder.append("#").append(rev);
	        int[] next = new int[builder.length()];
	        next[0]=0; //j表示当前已经匹配的字符数
	        for (int i = 1,j=0; i < next.length; i++) {
	            while (j > 0 && builder.charAt(i) != builder.charAt(j)) 
	            	j = next[j - 1];   //查放弃最长的匹配，寻找下一个次长的匹配
	            if(builder.charAt(i)==builder.charAt(j))
	            	j++;
	            next[i]=j;
	        }
	        return next[next.length - 1];   
	    }

	 public static void main(String [] args){
		 ShortestPalindrome p=new ShortestPalindrome();
		 String s="a";
		 String r=p.shortestPalindrome(s);
		 System.out.println("r="+r);
	 }
}
