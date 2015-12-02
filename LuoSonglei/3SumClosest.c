#include<stdio.h>
/*******************************************
    Author: LHearen
    E-mail: LHearen@126.com
    Time  :	2015-12-02 21:26
    Description: 
    Source: https://leetcode.com/problems/3sum-closest/
*******************************************/
int abs (int a)
{
  return a > 0 ? a : -a;
}

//Time Limit Exceeded
int threeSumClosest0(int *nums, int numsSize, int target)
{
  int closestSum = nums[0] + nums[1] + nums[2];
  int sum = 0;
  for (int i = 0; i < numsSize - 2; i++)
    for (int j = i + 1; j < numsSize - 1; j++)
        for (int k = j + 1; k < numsSize; k++)
        {
            sum = nums[i] + nums[j] + nums[k];
            if(abs(sum - target) < abs(closestSum - target))
            closestSum = sum;
        }
  return closestSum;
}


//Time Limit Exceeded
int threeSumClosest1 (int *nums, int numsSize, int target)
{
    int m = 1;
    int tmp = 0;
    int v = 0;
    int closestSum = nums[0] + nums[1] + nums[2];
    for(;m < numsSize; m = 3*m + 1);
    for(; m > 0; m /= 3)
    for(int i = m; i < numsSize; i++)
    {
        int j = i;
        v = nums[i];
        while(j >= m && v < nums[j - m])
            {
                tmp = nums[j];
                nums[j] = nums[j-m];
                nums[j-m] = tmp; 
                j -= m;
            }
        nums[j] = v;
    }   

    for (int i = 0; i < numsSize - 2; i++)
        for (int j = i + 1; j < numsSize - 1; j++)
            for (int k = j + 1; k < numsSize; k++)
            {
                tmp = nums[i] + nums[j] + nums[k];
                if (abs (tmp - target) < abs (closestSum - target))
                    closestSum = tmp;
                if (tmp > target && closestSum > target)
                {
                  if (abs (tmp - target) < abs (closestSum - target))
                    closestSum = tmp;
                    break;
                }
            }
  return closestSum;
}

//Accepted
int threeSumClosest2(int *nums, int numsSize, int target)
{
    int m = 1;
    int i = 0, j = 0, k = 0;
    int v;
    int closestSum = nums[0] + nums[1] + nums[2];
    for(; m < numsSize / 9; m = 3*m + 1);
    for(; m > 0;  m /= 3)
        for(int i = m; i < numsSize; i++)
        {
            v = nums[i];
            j = i;
            while(j >= m && nums[j - m] > v)
            {
                nums[j] = nums[j - m];
                j -= m;
            }
            nums[j] = v;
        }

    for(int i = 0; i < numsSize; i++)
        printf("%d\t", nums[i]);
    printf("\n");
    for(int i = 0; i < numsSize; i++)
    {
        j = i + 1;
        k = numsSize - 1;
        while(k > j)
        {
            v = nums[i] + nums[j] + nums[k];
            if(v > target)
                k--;
            else if(v < target)
                j++;
            else
                return v;
            if(abs(v - target) < abs(closestSum - target))
                closestSum = v;
        }
    }
    return closestSum;
}

void main()
{
    //setvbuf(stdout, NULL, _IOLBF, 0);
    int nums[] = {43,75,-90,47,-49,72,17,-31,-68,-22,-21,-30,65,88,-75,23,97,-61,53,87,-3,33,20,51,-79,43,80,-9,34,-89,-7,93,43,55,-94,29,-32,-49,25,72,-6,35,53,63,6,-62,-96,-83,-73,66,-11,96,-90,-27,78,-51,79,35,-63,85,-82,-15,100,-82,1,-4,-41,-21,11,12,12,72,-82,-22,37,47,-18,61,60,55,22,-6,26,-60,-42,-92,68,45,-1,-26,5,-56,-1,73,92,-55,-20,-43,-56,-15,7,52,35,-90,63,41,-55,-58,46,-84,-92,17,-66,-23,96,-19,-44,77,67,-47,-48,99,51,-25,19,0,-13,-88,-10,-67,14,7,89,-69,-83,86,-70,-66,-38,-50,66,0,-67,-91,-65,83,42,70,-6,52,-21,-86,-87,-44,8,49,-76,86,-3,87,-32,81,-58,37,-55,19,-26,66,-89,-70,-69,37,0,19,-65,38,7,3,1,-96,96,-65,-52,66,5,-3,-87,-16,-96,57,-74,91,46,-79,0,-69,55,49,-96,80,83,73,56,22,58,-44,-40,-45,95,99,-97,-22,-33,-92,-51,62,20,70,90};
    //int nums[] = {0, 1, 2};
    printf("Calculating...\n");
    int result = threeSumClosest2(nums, sizeof(nums) / sizeof(int), 284);
    printf("results: %d\n", result);
}
