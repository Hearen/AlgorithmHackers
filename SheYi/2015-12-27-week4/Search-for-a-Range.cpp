#include<stdio.h>
#include<string.h>
#include<stdlib.h>
//void main(){
//   int binSearch(int* nums,int target,int start1,int end1);
//   int* searchRange(int* nums, int numsSize, int target, int* returnSize);
//   int nums[10]={8,8,8,8,8,8,8,8,8,8};
//  // int result=binSearch(nums,8,0,9);
// //  printf("result=%d",result);
//   int r[2]={-1,-1};
//   int* re=searchRange(nums,10,8,r);
//   printf("result=%d ,%d",re[0],re[1]);
//}
int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
	int indexOfFirst(int* nums,int numsSize,int target);
	int indexOfLast(int* nums,int numsSize,int target);
	int* result=(int*)malloc(sizeof(int)*2);
	result[0]=indexOfFirst(nums,numsSize,target);
	result[1]=indexOfLast(nums,numsSize,target);
	*returnSize=2;
    return result;
}


int indexOfFirst(int* nums,int numsSize,int target){
	int binSearch(int* nums,int target,int start,int ends);
	int result=-1;
	int end=numsSize-1;
	int temp;
    while((temp=binSearch(nums,target,0,end))!=-1){
	   result=temp;
	   end=result-1;
	}
	return result;
}

int indexOfLast(int* nums,int numsSize,int target){
	int binSearch(int* nums,int target,int start,int ends);
	int result=-1;
	int start=0;
	int temp;
    while((temp=binSearch(nums,target,start,numsSize-1))!=-1){
	   result=temp;
	   start=result+1;
	}
	return result;
}

int binSearch(int* nums,int target,int start1,int end1){
    int start=start1;
	int end=end1;
    int mid=0;
	while(start<=end){
	   mid=(start+end+1)/2;
	if(nums[mid]==target) return mid;
	else if(nums[mid]<target){
	   start=mid+1;
	}else if(nums[mid]>target){
	   end=mid-1;
	 }
	}
	return -1;
}