package algorithm;

public class SortColors {
   public void sortColors(int[] nums) {
       int head=0,tail=nums.length-1;
       
       for(int i=head;i<=tail;i++){
		   switch(nums[i]){
		   case 0:if(i!=head){
			      swap(nums,head,i);head++;i--;
		          }  
		          break;
		   case 1:break;
		   case 2:if(i!=tail){
			      swap(nums,i,tail);tail--;i--;
		          }
		          break;
		   default:break;
		   }
	   }
    }
   public void swap(int[] data, int a, int b) {
       int t = data[a];
       data[a] = data[b];
       data[b] = t;
   }
   
   
   public static void main(String [] args){
	   SortColors sc=new SortColors();
	   int [] nums={2,0,0};
	   sc.sortColors(nums);
	   for(int i=0;i<nums.length;i++){
		   System.out.print(nums[i]+",");
	   }
   }
}
