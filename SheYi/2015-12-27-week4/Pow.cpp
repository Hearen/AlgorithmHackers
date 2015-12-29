#include<stdio.h>
#include<math.h>
#include<stdlib.h>
//void main(){
//	double myPow(double x, int n);
//	
//	double r=myPow(2.0,-2147483648);
//	printf("result=%lf",r);
//}

double myPow(double x, int n) {
	if(n==-2147483648){
	    return myPow(x,n+1)*(1/x);
	}
     bool sign=true;
	 if(n<0){  //判断符号
	   sign=false;
	   n=abs(n);  
	 }
	 int p[32]={0}; //记录2进制表示
	 int i=0;
	 while(n!=0){
	   p[i++]=n&1;
	   n=n>>1;
	 }
	 double* b=(double*)malloc(sizeof(double)*i);
	 b[0]=x;
	 for(int j=1;j<i;j++){
	    b[j]=b[j-1]*b[j-1];
	 }
	 double result=1.0;
	 for(int k=0;k<i;k++){
	     if(p[k]==1)
		 result=result*b[k];
	 }
	 if(sign) 
		 return result;
	 else 
		 return 1/result;
}