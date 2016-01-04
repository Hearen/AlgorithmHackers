/*package algorithm;

import java.util.ArrayList;
import java.util.List;
//这是考虑补0的情况   即 “45”--> 4.5.0.0 
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
    	List<String> str=new ArrayList<String>();
    	 int k=0;
    	 int a[]=new int[4];
    	 backtrace(a,k,s,str);
    	for(int i=0;i<str.size();i++)
    	System.out.println(str.get(i));
    	return str;
        
    }
    
    
    public boolean  isValid(String s){
          return "".equals(s)||(s.length()<4)&&(Integer.parseInt(s)<256);
    }
    
    public  void backtrace(int a[],int k,String s,List<String> str){
    	int[] c=new int[4];//对应可能的4中候选情况
    	int ncandidates;//对应每层的候选数
        int i; //counter
        if(is_a_solution(a,k,s))
        	process_solution(a,k,s,str);
        else if(k<3){
        	k=k+1;         
        	ncandidates=construct_candidates(a,k,s,c);
        	for(i=ncandidates;i>-1;i--){
        	    a[k]=c[i];
        	 //   make_move(a,k,s);
        	    backtrace(a,k,s,str);
        	 // unmake_move(a,k,s);
        	 //    if(finished) return;
        	} k=k-1;
        }
    }
      public boolean is_a_solution(int a[],int k,String s){
    	  if(k==3&&isValid(s.substring(a[1]+a[2]+a[3], s.length())))
    		  return true;
    	  else
    		  return false;
      }
      
      public void process_solution(int a[],int k,String s,List<String> str){
    	    String result="";
    	  if("".equals(s.substring(0, a[1])))  //1
    		  result+="0.";
    	  else
    		  result+= Integer.parseInt(s.substring(0, a[1]))+".";
    	  
      	  if("".equals(s.substring(a[1], a[1]+a[2])))   //2
    		  result+="0.";
    	  else
    		  result+= Integer.parseInt(s.substring(a[1], a[1]+a[2]))+".";
      	  
      	  if("".equals(s.substring(a[1]+a[2], a[1]+a[2]+a[3])))    //3
    		  result+="0.";
    	  else
    		  result+= Integer.parseInt(s.substring(a[1]+a[2], a[1]+a[2]+a[3]))+".";
      	  
      	  if("".equals(s.substring(a[1]+a[2]+a[3], s.length())))   //4
    		  result+="0";
    	  else
    		  result+= Integer.parseInt(s.substring(a[1]+a[2]+a[3], s.length()));
      	  if(!str.contains(result))
    	  str.add(result);
      }
      
      public int construct_candidates(int a[],int k,String s,int c[]){
    	   int count=0;
    	   int sum=0;
    	   for(int m=1;m<k;m++){
    		    sum+=a[m];
    	   }
    	   switch(s.length()-sum){
    	   default:
    	   case 3: if(isValid(s.substring(sum, sum+3))){
	               c[3]=3;count++;
                    }
    	   case 2: c[2]=2;count++;
    	   case 1: c[1]=1;count++;
    	   case 0: c[0]=0;
    	   }
    	   
    	  return count;
      }
      
      
      public static void main(String [] args){
    	  int k=0;
    	  int a[]=new int[4];
    	  String s="0000";
    	  RestoreIPAddresses p=new RestoreIPAddresses();
    	  p.restoreIpAddresses(s);
      }
}
*/


package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	/**
	 * 将字符串解析成IP地址
	 * 思路：将字符串解析成IP地址，要确定三个分割点的索引位置，即有解空间a=(a1,a2,a3);考虑用回溯的方法，依次搜索可行解；
	 * a1,a2,a3可选的值为1，2，3；这些可选的值的组合构成了一颗解空间树，用DFS搜索可行解
	 *  时间 4ms
	 *  复杂度
	 * @param s
	 * @return
	 */
    public List<String> restoreIpAddresses(String s) {
    	List<String> str=new ArrayList<String>();
    	int k=0;
    	int a[]=new int[4];
    	backtrace(a,k,s,str);
    	for(int i=0;i<str.size();i++)
    	System.out.println(str.get(i));
    	return str;
        
    }
    
    /**
     * 回溯求解
     * @param a  解空间数组 数据大小为3 a[i]表示第i组包含几个字符
     * @param k   k搜索的深度
     * @param s   待求解字符串
     * @param str  存解的list
     */
    public  void backtrace(int a[],int k,String s,List<String> str){
    	int[] c=new int[4];//对应可能的4中候选情况
    	int ncandidates;//对应每层的候选数
        int i; //counter
        if(is_a_solution(a,k,s))   //是否是合法的解
        	process_solution(a,s,str);  //保存当前解
        else if(k<3){              //不是合法的解，搜索深度小于3则继续搜索
        	k=k+1;             
        	ncandidates=construct_candidates(a,k,s,c); //构建第k层候选集
        	for(i=ncandidates;i>0;i--){      //依次遍历各个候选
        	    a[k]=c[i];                   //解空间赋值
        	    backtrace(a,k,s,str);        //进入下一层
        	} k=k-1;                  //搜索完之后，回溯到上一层
        }                                      
    }
    /**
     * 判断当前是否已得到一个合法的解
     * @param a  解空间数组
     * @param k  当前搜索深度
     * @param s  被搜索字符串
     * @return
     */
      public boolean is_a_solution(int a[],int k,String s){   
    	  //必须搜索到了最后一层，且剩余的字符串也是一个0-255之间合法值
    	  if(k==3&&isValid(s.substring(a[1]+a[2]+a[3], s.length())))
    		  return true;
    	  else
    		  return false;
      }
      /**
       * 判断是否是0-255之间的数
       * @param s
       * @return
       */
      public boolean  isValid(String s){
      	if("".equals(s)) return false;   //不能不包含任何数字
      	if(s.length()>1&&s.startsWith("0"))  //多个数字不能以“0”开头
      		return false;                     
      	else if((s.length()<4)&&(Integer.parseInt(s)<256))  //必须是3个字符以内，且要小于等于255  
      	   return true;
      	else 
      		return false;
      }
      /**
       * 将得到的当前解保存到str中
       * @param a
       * @param k
       * @param s
       * @param str
       */
      public void process_solution(int a[],String s,List<String> str){
    	     String result="";
    		  result+= s.substring(0, a[1])+"."
    	       +s.substring(a[1], a[1]+a[2])+"."
               + s.substring(a[1]+a[2], a[1]+a[2]+a[3])+"."
      	       + s.substring(a[1]+a[2]+a[3], s.length());
    	     
    		  str.add(result);
      }
      
      /*
       * 构建候选集
       */
      public int construct_candidates(int a[],int k,String s,int c[]){
    	   int count=0;
    	   int sum=0;  
    	   for(int m=1;m<k;m++){
    		    sum+=a[m];    //计算当前层的起始索引
    	   }
    	   switch(s.length()-sum){   //根据后面还剩余的字符情况来构建候选集
    	   default:
    	   case 3: if(isValid(s.substring(sum, sum+3))){
	               c[3]=3;count++;
                    }
    	   case 2: if(isValid(s.substring(sum, sum+2))){
    		        c[2]=2;count++;
    	           }
    	   case 1: c[1]=1;count++;
    	   case 0: break;
    	   }
    	   
    	  return count;
      }
      
      
      public static void main(String [] args){
    	  int k=0;
    	  int a[]=new int[4];
    	  String s="0000";
    	  RestoreIPAddresses p=new RestoreIPAddresses();
    	  p.restoreIpAddresses(s);
      }
}
