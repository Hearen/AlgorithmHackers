#include<stdio.h>
void main(){
  int mySqrt(int x) ;
  int r=mySqrt(36);
  printf("r=%d",r);
}

int mySqrt(int x) {
    
	long long head=0;
	long long tail=x;
	long long mid;
	while(head<tail){
		mid=(head+tail)/2;
		if(mid>46340||x<(mid*mid)){
		   tail=mid;
		}else if(x>((mid+1)*(mid+1))){
		   head=mid;
		}else if(x==(mid*mid))
			return mid;
		else if(x==((mid+1)*(mid+1)))
			return mid+1;
		else
			return mid;
	}
}