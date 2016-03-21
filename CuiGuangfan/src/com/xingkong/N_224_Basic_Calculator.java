package com.xingkong;

import java.util.Stack;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年2月29日 下午10:14:26 
* class description
*/
public class N_224_Basic_Calculator {
	public static int calculate(String s) {
		char[] array=s.trim().replaceAll(" ", "").toCharArray();
        Stack<String> numberStack=new Stack<String>();
        Stack<String> operatorStack=new Stack<String>();
        for(int i=0;i<array.length;i++){
        	if(Character.isDigit(array[i])){//遇到的是数字
        		String temp=String.valueOf(array[i]);
        		int tempI=i;
        		while(++tempI<array.length&&Character.isDigit(array[tempI])){
        			temp+=String.valueOf(array[tempI]);
        			i=tempI;
        		}
        		numberStack.push(temp);
        	}else if(array[i]=='('){//遇到的是(
        		operatorStack.push("(");
        	}else if(array[i]==')'){//遇到的是)
        		while(!operatorStack.peek().equals("(")){
        			numberStack.push(operatorStack.pop());
        		}
        		if(operatorStack.peek().equals("(")){
        			operatorStack.pop();
        		}
        	}else{//遇到的是运算符
        		while(!operatorStack.isEmpty()&&(operatorStack.peek().equals("+")||operatorStack.peek().equals("-"))){
        			numberStack.push(operatorStack.pop());
        		}
        		operatorStack.push(String.valueOf(array[i]));
        	}
        }
        while(!operatorStack.isEmpty()){
        	numberStack.push(operatorStack.pop());
        }
        Stack<String> reverseNumberStack=new Stack<String>();
        while(!numberStack.isEmpty()){
        	reverseNumberStack.push(numberStack.pop());
        }
        Stack<String> resultStack=new Stack<String>();
        while(!reverseNumberStack.isEmpty()){
        	String temp=reverseNumberStack.pop();
        	if(temp.equals("+")||temp.equals("-")){
        		Integer number1=Integer.valueOf(resultStack.pop());
        		Integer number2=Integer.valueOf(resultStack.pop());
        		if(temp.equals("+")){
        			resultStack.push(String.valueOf(number1+number2));
        		}else{
        			resultStack.push(String.valueOf(number2-number1));
        		}
        	}else{
        		resultStack.push(temp);
        	}
        }
        return Integer.valueOf(resultStack.pop());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_224_Basic_Calculator.calculate(" 30"));
	}

}
