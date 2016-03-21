package com.xingkong;

import java.util.Stack;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月8日 下午2:46:38 
* class description
*/
public class N_20_Valid_Parentheses {
	public static boolean isValid(String s) {
		char[] array=s.toCharArray();
		Stack<Character> v=new Stack<Character>();
		for(int i=0;i<array.length;i++){
			if(!v.isEmpty()){
				if((v.peek().charValue()=='('&&array[i]==')')||
						(v.peek().charValue()=='{'&&array[i]=='}')||
						(v.peek().charValue()=='['&&array[i]==']')){
					v.pop();
				}else{
					v.push(array[i]);
				}
			}else{
				v.push(array[i]);
			}
		}
		if(v.size()!=0) return false;
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_20_Valid_Parentheses.isValid("{[[}[]]}"));
	}

}
