package week7;

public class JumpGameII {
   public int jump(int[] nums) {
	   if(nums.length<2) return 0;
       int curmax=-1;
       int premax=-1;
       int count=0;
	   for(int i=0;i<nums.length;i++){
           if(nums[i]+i>curmax)
        	   curmax=nums[i]+i;
		   if(curmax>=nums.length-1){
    		   return count+1;
    	   }
		   if(i>=premax){
    		   count++;
    		   premax=curmax;
    	   }
       }
	   return count;
    }
   
   public static void main(String [] args){
	   JumpGameII j=new JumpGameII();
	   int[] nums={1,1,1,1};
	   int r=j.jump(nums);
	   System.out.println("result="+r);
   }
}
