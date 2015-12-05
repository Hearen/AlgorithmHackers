#include <stdio.h>
#include<math.h>
int main()
{
	int nums[4]={-1,3,4,7};
	int numSize=4;
	bool search(int* nums, int numsSize, int target);
	//int result=search(nums,numSize,2);
  	printf("result= %d",result);
}


/**Search in Rotated Sorted Array II**/
bool search(int* nums, int numsSize, int target) {
    //int head=0, tail=numsSize-1,mid=0;
	bool binarySearch(int* nums,int h,int t,int target);
	return binarySearch(nums,0,numsSize-1,target);
}

bool binarySearch(int* nums,int h,int t,int target){
     int head=h, tail=t,mid=0;
	while(head<=tail){
		mid=(head+tail+1)/2;
		//check 
		if(mid==head||mid==tail){
		    if(target==nums[head]){
			   return true;
			}else if(target==nums[tail]){
			   return true;
			}else return false;
		}

	 if(target==nums[head]) return true;
	  else if(target==nums[tail]) return true;  
	  else if(target>nums[head]){
		 if(nums[mid]>target){
			tail=mid;
			 // return binarySearch(nums,head,mid,target);
		 }else if(nums[mid]<target){
		   if(nums[mid]<nums[head]){
		       tail=mid; 
		   }else if(nums[mid]>nums[head]){
		       head=mid; 
		   }else
			   return binarySearch(nums,head,mid,target)+binarySearch(nums,mid+1,tail,target);
		 }else return true;
	  }else if(target<nums[tail]){
	      if(nums[mid]<target){
		   head=mid;
			  //  return binarySearch(nums,mid,tail,target);
		  }else if(nums[mid]>target){
		     if(nums[mid]>nums[tail]){
			     head=mid;
			 }else if(nums[mid]<nums[tail]){
				 tail=mid;
			 }else
				 return binarySearch(nums,head,mid,target)+binarySearch(nums,mid+1,tail,target);
		  }else
			  return true;
	  }
	  else 
		  return false;

    
	}
}

