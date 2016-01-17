package week7;

public class BestTimetoBuyandSellStock {
	//121. Best Time to Buy and Sell Stock
	//AC 4ms  
	/* public int maxProfit(int[] prices) {
		 if(prices.length <2) return 0;
	     int min=Integer.MAX_VALUE;
	     int profit=0;
	     for(int i=0;i<prices.length;i++){
	       if(maxOrMin(prices,i)==0) continue;
	       else if(maxOrMin(prices,i)==1){
	    	   if(prices[i]<min) {
	    		   min=prices[i]; 
	    	   }
	       }else if(maxOrMin(prices,i)==2){
	    	   if(prices[i]>min){
	    		   int tempProfit=prices[i]-min;
	    		   if(tempProfit>profit){
	    			   profit=tempProfit;
	    		   }
	    	   }
	       }
	     }
		 return profit;   
	    }
	 
	 private int maxOrMin(int[] nums,int index){
		 if(index==0){
			 if(nums[0]<=nums[1]) return 1;
			 else return 0;
		 }else if(index==nums.length-1){
			 if(nums[index-1]<=nums[index]) return 2;
			 else return 0;
		 }else if(nums[index]<=nums[index+1]&&nums[index-1]>=nums[index]){
				 return 1;
			 }
		 else if(nums[index]>=nums[index-1]&&nums[index]>=nums[index+1]){
			    return 2;
		 }else 
			 return 0;
		 
		 
	 }*/
	
	//122. Best Time to Buy and Sell Stock II  AC 3m
	/*   public int maxProfit(int[] prices) {
		   if(prices.length <2) return 0;
	       int min=0,profit=0;
	       boolean flag=false;
		   for(int i=0;i<prices.length;i++){
			   if(maxOrMin(prices,i)==1){
				   flag=true;
				   min=prices[i];
			   }else if(maxOrMin(prices,i)==2&&flag){
				   profit+=prices[i]-min;
				   flag=false;
			   }
		   }
		   
		   return profit;
	    }
	 
	   private int maxOrMin(int[] nums,int index){
			 if(index==0){
				 if(nums[0]<=nums[1]) return 1;
				 else return 0;
			 }else if(index==nums.length-1){
				 if(nums[index-1]<=nums[index]) return 2;
				 else return 0;
			 }else if(nums[index]<=nums[index+1]&&nums[index-1]>=nums[index]){
					 return 1;
				 }
			 else if(nums[index]>=nums[index-1]&&nums[index]>=nums[index+1]){
				    return 2;
			 }else 
				 return 0;
	   }*/
	//III AC 6ms
	//思路：根据I和II可以知道：（1）两次交易的能取得的最大利益一定大于一次交易取得的最大利益；（2）交易点一定是数组中的极大值点和极小值点。假设
	//start和end数组分别表示在第几天交易 ，start表示买入，end表示卖出，索引表示第几次交易，
	//遍历数组前n个元素可以取得的最大利益(2次交易)为分别是在第start[0]天买入，在第end[0]天抛出和第start[1]天买入，第end[1]抛出，那么
	//接着遍历数组找到交易（start[2]，end[2]），这时需要比较在这三组极值中，找到使两次交易利益和最大的组合，即要求profit(start[0],end[1])+profit(start[2],end[2])
	//和profit(start[0],end[0])+profit(start[1],end[2])中更大的一个，然后更新start和end数组（也就是getRange函数做到工作）；
	  public int maxProfit(int[] prices) {
		  if(prices.length <2) return 0;
	      int profit=0;
		  int[] start=new int[3];
	      int[] end=new int[3];
	      boolean flag=false;
	      int j=0,k=0;
		     for(int i=0;i<prices.length;i++){  //一次遍历数组
		    	 if(maxOrMin(prices,i)==1){  //极小值
		    	  if(j<2)   
		    	  start[j++]=i;
		    	  else{   //已经有两次交易
		    		  if(start[2]==0)  start[j++]=i;  //当前为第三次交易的起始值 ，
		    		  else{
		    		  if(prices[i]<prices[start[2]])   //记录从第二次交易结束之后，第三次交易买入的最小值
		    			  start[j++]=i;
		    		  else
		    			  j++;
		    		  }
		    	  }
		    	  flag=true;
		       }else if(maxOrMin(prices,i)==2&&flag){  //极大值
		    	   flag=false;
		    	   end[k++]=i;
		    	   if(k==3&&j==3){     //如果得到了一个可行的第三次交易 ，就要考虑是否可以得到一个更大利益的2次交易的组合
		    		   getRange(start,end,prices);  // 如果找到就更新
		    		   k=2;j=2;  //k和j都置为2，继续去寻找可行的第三次交易来更新最大利益组合
		    	   }
		       }
		     }
		   int length=end.length<2?end.length:2;  //只计算两次交易的
		  for(int i=0;i<length;i++){
		     profit+=prices[end[i]]-prices[start[i]];
		  }
		     return profit;
	    }
	  
	  //判断第三个可行交易是否可以取得更大的两次交易最大利益，如果可以就更新start和end的值
	  //(start[0],end[0]),(start[1],end[1])指向的是到目前为止取得最大利益的交易
	  public void getRange(int[] start,int[] end,int[] prices){
		   int num10=prices[end[0]]-prices[start[0]];
		   int num11=prices[end[1]]-prices[start[1]];
		   int num12=prices[end[2]]-prices[start[2]];
		   int num20=prices[end[1]]-prices[start[0]];
		   int num21=prices[end[2]]-prices[start[1]];
		   int[] r1=new int[2];
		   int[] r2=new int[2];
		   maxThreeNums(num10,num11,num20,r1);
		   maxThreeNums(num11,num12,num21,r2);
		   if(r1[0]+num12>r2[0]+num10){   
			   switch(r1[1]){
			   case 1:break;
			   case 2:start[0]=start[1];end[0]=end[1];break;
			   case 3: end[0]=end[1];break;
			   default:break;
			   }
			   start[1]=start[2];end[1]=end[2];start[2]=0;end[2]=0;
		   }else{
			   switch(r2[1]){
			   case 1:break;
			   case 2:start[1]=start[2];end[1]=end[2];start[2]=0;end[2]=0;break;
			   case 3:end[1]=end[2];start[2]=0;end[2]=0;break;
			   default: break;
			   }
		   }
		   
	  }
	  //比较3个数 哪一个更大  result[0]存放最大值 result[1]存放最大值的索引
	  public void maxThreeNums(int num1,int num2,int num3,int[] result){
		  int maxNum=max(max(num1,num2),num3);
		  if(maxNum==num1)  result[1]=1;
		  else if(maxNum==num2)  result[1]=2;
		  else if(maxNum==num3)  result[1]=3;
		  else result[1]=0;
		  result[0]=maxNum;
	  }
	  
	  public int max(int num1,int num2){
		  return num1>num2?num1:num2;
	  }
	  //判断是否是极值  极小值返回1 极大值返回2 不是极值返回0
	  private int maxOrMin(int[] nums,int index){
			 if(index==0){
				 if(nums[0]<=nums[1]) return 1;
				 else return 0;
			 }else if(index==nums.length-1){
				 if(nums[index-1]<=nums[index]) return 2;
				 else return 0;
			 }else if(nums[index]<=nums[index+1]&&nums[index-1]>nums[index]){
					 return 1;
				 }
			 else if(nums[index]>=nums[index-1]&&nums[index]>nums[index+1]){
				    return 2;
			 }else 
				 return 0;
	   }
	 public static void main(String [] args){
		 BestTimetoBuyandSellStock best=new BestTimetoBuyandSellStock();
		 int[] prices={1,3,5,4,3,7,6,9,2,4};
		 
		 int r=best.maxProfit(prices);
		 System.out.println("max profit is "+r);
	 }
}
