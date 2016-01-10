/*思想 前后两个指针分别指向0 和 2的插入点*/
void sortColors(int* nums, int numsSize) {
    int i = 0,j = numsSize-1,k = 0;
    int tmp;
    while(k<=j){
        if(nums[k] == 0){
            if(k>i) swap(nums,i++,k);
            else k+=1;
        }else if(nums[k]==2){
            swap(nums,j--,k);
        }else{
            k+=1;
        }
    }
}
/*扫描两遍 首先计数，然后还原*/
void sortColors(int* nums, int numsSize){
    int i=0,j=0,k=0;
    int c;
    for(c = 0;c<numsSize;++c){
        if(nums[c] == 0)
            i++;
        else if(nums[c]== 1){
            j++;
        }else{
            k++;
        }
    }
    for(c=0;c<numsSize;c++){
        if(c < i)
            nums[c] = 0;
        else if(c < i+j)
            nums[c] = 1;
        else
            nums[c] = 2;
    }
}
/*同样是上面的思路，但是便统计边移动*/
void sortColors(int* nums, int numsSize){
    int i = -1,j=-1,k=-1;
    int c;
    for(c = 0;c<numsSize;++c){
        if(nums[c] == 0){
            nums[++k] = 2;
            nums[++j] = 1;
            nums[++i] = 0;
        }else if(nums[c] == 1){
            nums[++k] = 2;
            nums[++j] = 1;
        }else{
            nums[++k] = 2;
        }

    }
}
void swap(int *nums,int x,int y){
    int tmp = nums[x];
    nums[x] = nums[y];
    nums[y] = tmp;
}
