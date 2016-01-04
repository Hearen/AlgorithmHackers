package com.xingkong;

import java.util.ArrayList;
import java.util.List;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2015年12月29日 上午9:21:14 
* class description
*/
public class Test {

	public static void main(String[] args) {
        String[]test=new String[3];
        for(String i:test)
        	System.out.println(i);
    }
     
    public static String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }

}
