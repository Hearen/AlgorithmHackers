package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年1月22日 上午8:30:46 
* class description
*/
public class UglyNumber_263 {
	private int reduceBy(int num,int m){
		while(num%m==0)
			num=num/m;
		return num;
	}
	public boolean isUgly(int num) {
		if(num==0) return false;
        int num1=reduceBy(reduceBy(reduceBy(num,2),3),5);
		if(num1!=1) return false;
        return true;
    }
	public static void main(String[] args) {
		UglyNumber_263 un=new UglyNumber_263();
		System.out.println(un.isUgly(0));

	}

}
