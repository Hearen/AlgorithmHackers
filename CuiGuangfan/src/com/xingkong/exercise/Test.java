package com.xingkong.exercise;

import java.util.TreeMap;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年2月24日 下午2:37:01 
* class description
*/
//public class Test {
//
//	public static void main(String[] args) {
//		String str1 = "a";   
//		String str2 = "bc";   
//		String str3 = "a"+"bc";   
//		String str4 = str1+str2;   
//		String str5 = "abc";     
//		System.out.println(str3==str4); 
//		System.out.println(str4==str5);
//		str4 = (str1+str2).intern();   
//		System.out.println(str3==str4);
//		System.out.println(str4==str5);
//		String str6=new String("123");
//		System.out.println(str6.intern()==str6);
//		String str7="123";
//		System.out.println(str6==str7);
//		System.out.println(str6.intern()==str6);
//		String str8=new StringBuilder("ja").append("vaaaaaaaaaaaaa").toString();
//		System.out.println(str8.intern()==str8);
//	}
//
//}
public class Test extends Base{
	 
    static{
        System.out.println("test static");
    }
     
    public Test(){
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new Test();
    }
}
 
class Base{
     
    static{
        System.out.println("base static");
    }
     
    public Base(){
        System.out.println("base constructor");
    }
}