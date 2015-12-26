#include<stdio.h>
int mySqrt(int x) {
    if(x ==0) return 0;
    if(x > 0 && x < 4) return 1;
    //change from long long to unsigned long long accepted
    unsigned long long tmp = 0;
    unsigned long long  left = 0,right = (x+1) / 2;
    unsigned long long mid;
    while(left < right){
        mid = (left + right) / 2;
        tmp = mid * mid;
        if(tmp == x) return mid;
        else if(tmp > x) right = mid - 1;
        else left = mid + 1;
    }
    tmp = right * right;
    if(tmp > x) return right - 1;
    else return right;
}
int main(){
    printf("%d\n",mySqrt(7));
}
