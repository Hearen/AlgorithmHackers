#include <stdio.h>
#include<math.h>
int main()
{
	int nums[4]={1,3,3,4};
	int numSize=4;
        int removeDuplicates(int* nums, int numsSize);

	int result=removeDuplicates(nums,numSize);
  	printf("result= %d",result);
}

/**Remove Duplicates from Sorted Array II**/
int removeDuplicates(int* nums, int numsSize) {
    int swap(int *a,int *b);
	int pre=nums[0];
	int count=1;
	int taint=1;
	if(numsSize==0)  return 0;
	if(numsSize==1)  return 1;
	if(numsSize==2)  return 2;
	for(int i=1;i<numsSize;i++){
	   if(nums[i]==pre){
		   pre=nums[i];
		   count++;
		   if(count<3){
			   if(taint>1){
			   swap(&nums[taint],&nums[i]);
			   taint++;
			  }
		   }else{
		     if(taint<2){
			    taint=i;
			  }
		   }
	       continue;
	   }else if(nums[i]!=pre){
		    pre=nums[i];
			count=1;
			if(taint>1){
			   swap(&nums[taint],&nums[i]);
			   taint++;
			}
          
	   }
	  
	}
	if(taint>1)
        return taint;
	else
		return  numsSize;
}

int swap(int *a,int *b)
{
int temp;
temp=*a;
*a=*b;
*b=temp;
return 0;
}
