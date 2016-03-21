package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年1月22日 上午8:53:43 
* class description
*/
public class UglyNumberII {
	private int min(int num1,int num2,int num3){
		int min=Integer.MAX_VALUE;
		if(num1<min) min=num1;
		if(num2<min) min=num2;
		if(num3<min) min=num3;
		return min;
	}
	public int nthUglyNumber(int n) {
		int[]nums=new int[n];
		nums[0]=1;
		int num1=2;
		int index1=0;
		int num2=3;
		int index2=0;
		int num3=5;
		int index3=0;
		for(int i=1;i<n;i++){
			int min=min(num1,num2,num3);
			nums[i]=min;
			if(min==num1)
				num1=2*nums[++index1];
			if(min==num2)
				num2=3*nums[++index2];
			if(min==num3)
				num3=5*nums[++index3];
		}
		return nums[n-1];
    }
	public static void main(String[] args) {
		UglyNumberII un=new UglyNumberII();
		for(int i=1;i<=10;i++)
			System.out.println(un.nthUglyNumber(i));
	}

}
