package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月3日 上午8:42:55 
* class description
*/
public class N_43_Multiply_Strings {
	
	public static String multiply(String num1, String num2) {
        char[] array1=num1.toCharArray();
        char[] array2=num2.toCharArray();
        char[] num1Array=array1;
        char[] num2Array=array2;
        
        if(array1.length<array2.length){
        	num1Array=array2;
        	num2Array=array1;
        }
        char[] result=new char[num1Array.length+num2Array.length];
        for(int i=0;i<result.length;i++)
        	result[i]='0';
        for(int i=num2Array.length-1;i>=0;i--){
        	int addition=0;
        	int j=num1Array.length-1;
        	for(;j>=0;j--){
	        	int temp=result[i+j+1]-48+(num2Array[i]-48)*(num1Array[j]-48)+addition;
	        	result[i+j+1]=(char) (temp%10+48);
	        	addition=temp/10;
        	}
        	if(addition>0&&j<result.length){
        		result[i+j+1]=(char) (addition+48);
        	}
        }
        StringBuilder str = new StringBuilder();
        boolean flag=false;
        for(int i=0;i<=result.length-1;i++){
        	if(result[i]!='0') flag=true;
        	if(flag) str.append(result[i]);
        }
        if(!flag) return "0";//防止出现乘法结果为0的情况
        return str.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_43_Multiply_Strings.multiply("0", "0"));
	}

}
