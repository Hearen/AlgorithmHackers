package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
	 public List<List<Integer>> subsets(int[] nums) {
	     List<List<Integer>>  result=new ArrayList<List<Integer>>();   
	     int a[]=new int[nums.length];
	     //bubblesort(nums);
	     subQuickSort(nums,0,nums.length-1);
	     traceback(a,-1,nums,result);
	    /* System.out.println("[");
	     for(int i=0;i<result.size();i++){
	       System.out.print("	[");
	       for(int j=0;j<result.get(i).size();j++){
	    	   System.out.print(result.get(i).get(j));
	    	  if(j!=result.get(i).size()-1)
	    	   System.out.print(",");
	       }
	       if(i!=result.size()-1)
	       System.out.println("],");
	       else
	    	   System.out.println("]");
	     }
	     System.out.println("]");*/
	     return result;
	 }
	 
	 public void traceback(int[] a,int k,int[] nums,List<List<Integer>> result){
		 List<Integer> list=new ArrayList<Integer>();
		 int c[]={0,1};
		 if(k==nums.length-1){
		     for(int i=0;i<=k;i++){
		    	 if(a[i]==1)
		    		 list.add(nums[i]);
		     }
		     if(!result.contains(list))
		     result.add(list);
		   //  list.clear();
		 }
		 if(k<nums.length-1){
			 k=k+1;
			 for(int i=0;i<2;i++){
				 a[k]=c[i];
				 traceback(a,k,nums,result);
			 }
			 k=k-1;
		 }
	 }
     //Ã°ÅİÅÅĞò
/*	 public  void bubblesort(int [] a){
		 int temp;
		   for(int i=0;i<a.length-1;i++){  
		        for(int j=0;j<a.length-1-i;j++){  
		        if(a[j]>a[j+1]){  
		            temp=a[j];  
		            a[j]=a[j+1];  
		            a[j+1]=temp;  
		        }  
		        }  
		    }  
	 }*/
	 //¿ìËÙÅÅĞò
	 private static void subQuickSort(int[] array, int start, int end) {  
	        if (array == null || (end - start + 1) < 2) {  
	            return;  
	        }  
	  
	        int part = partition(array, start, end);  
	  
	        if (part == start) {  
	            subQuickSort(array, part + 1, end);  
	        } else if (part == end) {  
	            subQuickSort(array, start, part - 1);  
	        } else {  
	            subQuickSort(array, start, part - 1);  
	            subQuickSort(array, part + 1, end);  
	        }  
	    }  
	  
	    private static int partition(int[] array, int start, int end) {  
	        int value = array[end];  
	        int index = start - 1;  
	  
	        for (int i = start; i < end; i++) {  
	            if (array[i] < value) {  
	                index++;  
	                if (index != i) {  
	                   exchangeElements(array, index, i);  
	                }  
	            }  
	        }  
	  
	        if ((index + 1) != end) {  
	            exchangeElements(array, index + 1, end);  
	        }  
	  
	        return index + 1;  
	    }  
	
 

    public static void exchangeElements(int[] array, int index1, int index2) {  
        int temp = array[index1];  
        array[index1] = array[index2];  
        array[index2] = temp;  
    }  

	 
	 public static void main(String [] args){
		 SubsetsII s=new SubsetsII();
		 int nums[]={1,3,3};
		 s.subsets(nums);
		 
	 }
	 
}  
