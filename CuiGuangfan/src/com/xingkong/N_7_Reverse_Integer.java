package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月5日 下午7:04:59 
* class description
*/
public class N_7_Reverse_Integer {
	public static int reverse(int x) {
        String str=String.valueOf(x);
        String prefix="";
        if(str.indexOf("-")!=-1){
        	str=str.substring(1, str.length());
        	prefix="-";
        }
        char[] array=str.toCharArray();
        char[] reverseArray=new char[array.length];
        for(int i=0;i<array.length;i++){
        	reverseArray[reverseArray.length-1-i]=array[i];
        }
        try{
        	return Integer.valueOf(prefix+String.valueOf(reverseArray));
        }catch(Exception e){
        	return 0;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(123));
	}

}
