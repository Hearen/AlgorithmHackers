package week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//I AC 7ms 
public class Permutations {
	//I AC 7ms 回溯法  依次去选择排序的元素 当所有的元素都排完了 即求解到了第n层（n为数组元素的个数），则得到一组解，接着回溯
	//去找下一组解  求解到每一层 就根据当前的情况求解当前层所有可选的值
/*	 public List<List<Integer>> permute(int[] nums) {
	       List<List<Integer>> rlist=new ArrayList<List<Integer>>(); 
	       List<Integer> cur=new ArrayList<Integer>();
	       if(rlist==null) return rlist;
	       traceback(0,nums,cur,rlist);
	       return rlist;
	    }
	 
	 public void traceback(int k,int[] nums,List<Integer> cur,List<List<Integer>> rlist){
		 if(k==nums.length){
			 List<Integer> temp=new ArrayList<Integer>(cur);
			 rlist.add(temp);
		 }else{
			 k++;
			 List<Integer> c=new ArrayList<Integer>();
			 int count=construct_candidate(nums,cur,c);
			 for(int i=0;i<count;i++){
				 cur.add(c.get(i));
				 traceback(k,nums,cur,rlist);
				 cur.remove(c.get(i));
			 }
			 k--;
		 }
	 }
	 
	 public int construct_candidate(int[] nums,List<Integer> cur,List<Integer> c){
		 int length=nums.length;
		 for(int i=0;i<length;i++){
			 if(cur.contains(nums[i]))
				continue;
			 else
				 c.add(nums[i]);
		 }
		 return c.size();
	 }*/
	 
	   public List<List<Integer>> permuteUnique(int[] nums) {
	      List<List<Integer>> rlist=new ArrayList<List<Integer>>();
	      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	      List<Integer> cur=new ArrayList<Integer>();
	      if(nums.length<1) return rlist;
	      //初始化hashmap
	      for(int i=0;i<nums.length;i++){
	    	  if(map.containsKey(nums[i]))
	    	     map.put(nums[i], map.get(nums[i])+1);
	    	  else
	    		  map.put(nums[i], 1);
	      }
	      traceback(0,nums,map,cur,rlist);
	      return rlist;
	    }
	   
	   public void traceback(int k,int[] nums,HashMap<Integer,Integer> map,List<Integer> cur,List<List<Integer>> rlist){
		   if(k==nums.length){
			  ArrayList<Integer> temp=new ArrayList<Integer>(cur);  
			  rlist.add(temp);
		   }else{
			   k++;
			   List<Integer> c=new ArrayList<Integer>();
			   int count=construct_candidate(map,c);
			   for(int i=0;i<count;i++){
				   cur.add(c.get(i));
				   updateMap(0,c.get(i),map);
				   traceback(k,nums,map,cur,rlist);
				   updateMap(1,c.get(i),map);
				   cur.remove(cur.size()-1);
			   }
			   k--;
			  
		   }
	   }
	   
	   public void updateMap(int type,int element,HashMap<Integer,Integer> map){
		   if(type==0){//从map中移除该元素
		     Integer value= map.get(element);
		    if(null==value) return ;
		    else if(value.equals(1)){
		       map.remove(element);
		    }
		    else if(value>1){
		    	map.put(element, value-1);
		    }
		   }else if(type==1) {//添加元素到map中
		      Integer value=map.get(element);
		      if(null==value){
		    	  map.put(element, 1);
		      }else{
		    	  map.put(element, value+1);
		      }
		   }
		   
	   }
	   
	   public int construct_candidate(HashMap<Integer,Integer> map,List<Integer> r){
		   Iterator it=map.entrySet().iterator();
		   while(it.hasNext()){
			   Map.Entry entry=(Map.Entry)it.next();
			   r.add((Integer)entry.getKey());
		   }
		   return r.size();
	   }
	   
	 public static void main(String [] args){
		 int[] nums={1,1,2,2};
		 Permutations p=new Permutations();
		 List<List<Integer>> list=p.permuteUnique(nums);
		 System.out.println("[");
		 for(int i=0;i<list.size();i++){
			 System.out.print("[");
			 for(int j=0;j<list.get(0).size();j++){
				 System.out.print(list.get(i).get(j)+" ");
			 }
			 System.out.println("]");
		 }
		 System.out.println("]");
		 System.out.println("length="+nums.length+" size="+list.size());
	 }
}
