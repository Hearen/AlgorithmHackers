#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
	int nums[4]={-4,2,0,1};
	int numSize=4;
        int threeSumClosest(int* nums, int numsSize, int target);
	int result=threeSumClosest(nums,numSize,2);
  	printf("result= %d",result);
}

/**3Sum Closest**/
int threeSumClosest(int* nums, int numsSize, int target) {
    void quicksort(int* s, int l, int r);//快排
	int twoSumClosest(int* nums,int numsSize, int target);//子问题 2sum
	int* temp=(int*)malloc(sizeof(int) * (numsSize-1)); //new int[numsSize-1];
	 
	int start=0;
	int* interResult=(int*)malloc(sizeof(int) * (numsSize)); //new int[numsSize];
	for(int i=0;i<numsSize;i++){
		start=0;
		for(int j=0;j<numsSize;j++){
		     if(i==j) continue;
			 temp[start++]=nums[j];
		}
		quicksort(temp,0,numsSize-2);
	    interResult[i]=nums[i]+twoSumClosest(temp,numsSize-1,target);
	} 
	int result=interResult[0];
	for(int k=1;k<numsSize;k++){
       if(abs(result-target)>abs(interResult[k]-target))
		   result=interResult[k];
	}
	return result;
}



int twoSumClosest(int* nums,int numsSize, int target){
    int head=0,tail=numsSize-1;
	int distance; //当前head 和 tail的值与target的差值
	int tempSum;
	int curNearest=nums[head]+nums[tail];//pow(2.0,31.0)-1; //当前与target值最接近的两个数和
	while(head<tail){
		tempSum=nums[head]+nums[tail];
		distance=tempSum-target;
	if(distance<0){
		head++;
	}else if(distance>0){
	    tail--;
	}else
	   return target;
	   if(abs(distance)<abs(curNearest-target))
			curNearest=tempSum;
	}
	return curNearest;
}

//网上找的快速排序算法
void quicksort (int* a, int lo, int hi)
{
//  lo is the lower index, hi is the upper index
//  of the region of array a that is to be sorted
    int i=lo, j=hi, h;

    // comparison element x
    int x=a[(lo+hi)/2];

    //  partition
    do
    {    
        while (a[i]<x) i++; 
        while (a[j]>x) j--;
        if (i<=j)
        {
            h=a[i]; a[i]=a[j]; a[j]=h;
            i++; j--;
        }
    } while (i<=j);

    //  recursion
    if (lo<j) quicksort(a, lo, j);
    if (i<hi) quicksort(a, i, hi);
}
/** Trapping Rain Water **/
还未完成

/** Word Search **/
还未完成