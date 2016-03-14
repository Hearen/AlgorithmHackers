package week8;

public class HouseRobber {
	//I AC 1ms
    public int robI(int[] nums) {
		  if(nums.length<1) return 0;
		  if(nums.length<2) return nums[0];
	      int[] d=new int[nums.length];
	      d[0]=nums[0];
	      d[1]=nums[0]>nums[1]?nums[0]:nums[1];
	      for(int i=2;i<nums.length;i++){
	    	  d[i]=d[i-1]>d[i-2]+nums[i]?d[i-1]:d[i-2]+nums[i];
	      }
		  return d[nums.length-1];
	    }
	  
	  //II  AC 1ms
	  public int rob(int[] nums) {
	      if(nums.length<1) return 0;
	      if(nums.length<2) return nums[0];
	      if(nums.length<3) return nums[0]>nums[1]?nums[0]:nums[1];
	      int[] numHead=new int[nums.length-3];
	      int[] numTail=new int[nums.length-3];
	      int[] numMiddle=new int[nums.length-2];
	      int k=0;
	      for(int i=2;i<nums.length-1;i++){
	    	  numHead[k++]=nums[i];
	      }
	      k=0;
	      for(int i=1;i<nums.length-2;i++){
	    	  numTail[k++]=nums[i];
	      }
	      k=0;
	      for(int i=1;i<nums.length-1;i++){
	    	  numMiddle[k++]=nums[i];
	      }
	    return   max3(robI(numHead)+nums[0],robI(numTail)+nums[nums.length-1],robI(numMiddle));
	    }
	  
	  public int max3(int a,int b,int c){
		  if(a>b)
			  return a>c?a:c;
			  else
				  return b>c?b:c;
	  }
	  public static void main(String [] args){
		  HouseRobber h=new HouseRobber();
		  int[] nums={0,0};
		  int r=h.rob(nums);
		  System.out.println("result="+r);
	  }
}
