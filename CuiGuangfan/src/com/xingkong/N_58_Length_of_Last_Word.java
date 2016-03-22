package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月14日 上午8:28:22 
* class description
*/
public class N_58_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        if(s==null||s.trim().equals("")) return 0;
        String[] array=s.trim().split(" ");
        return array[array.length-1].length();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_58_Length_of_Last_Word n=new N_58_Length_of_Last_Word();
		System.out.println(n.lengthOfLastWord("Hello World"));
	}

}
