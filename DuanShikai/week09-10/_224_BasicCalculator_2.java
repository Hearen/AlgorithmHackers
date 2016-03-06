package com.sky.leetcode;

import java.util.Stack;

/**
 * @author DuanSky
 * @date 2015年12月15日 下午8:00:14
 * @content 
 */

public class _224_BasicCalculator_2 {
	
	public static void main(String args[]){
		String s=" 1+(5)";
		System.out.println(calculate(s));
	}
	private static int calculate_(String s) {
		int result=0;
		return result;
	}
	
	
	//TODO 下面的方法太麻烦，看能不能够简化。
	public static int calculate(String s) {
        Stack<String> stack=new Stack<String>(); int i=0;
        while(i<s.length()){
        	char current=s.charAt(i);
        	if(current == ' ') i++; //如果当前的字符是空格，则跳过空格，继续往下搜索
        	else if(Character.isDigit(current)){ //如果当前的字符是数字
        		int start=i; //记录数字的起始位置和终止位置
        		//MISTAKE 当i指向最后一个字符时，无论最后一个字符是否是数字，都会跳出循环，即当判断完倒数第二个字符后，便会跳出循环，
        		//跳出循环时，i=s.length()-1,即指向了最后一个字符
        		while(i<s.length()-1 && Character.isDigit(s.charAt(++i))){} //如果当前位置不是数字，则跳出循环
        		//MISTAKE 注意这里需要对i进行判断，因为i有可能是到达了s的末尾。即使i到达了末尾，也存在末尾的字符是否是数字两种可能。
        		stack.push(s.substring(start,i==s.length()-1 && Character.isDigit(s.charAt(i))? (++i) : i)); 
        	}
        	else if(current == ')'){ //如果当前的字符是右括号
        		i++;
        		if(stack.isEmpty()) return 0;
        		while(!stack.isEmpty() && !stack.peek().equals("(")){
        			int right=Integer.valueOf(stack.pop()); //右边的值
        			String operation=stack.pop(); //计算符号
        			//MISTAKE (1) 如果只是单值而不是两个数组成的算式，这种情况需要直接返回。
        			if(operation.equals("(")){
        				stack.push(right+"");
        				break;
        			}
        			int left=Integer.valueOf(stack.pop()); //左边的值
        			//MISTAKE 在java里，不要用==来判断两个字符串是否相等！，用equals来判断两个字符串是否相等。
        			if(!stack.isEmpty() && stack.peek().equals("-")){ //判断左边的值的符号
        				left=-left;
        				stack.pop();
        				stack.push("+");
        			}
        			//MISTAKE 在入栈之前，先判断是否到达了左括号边缘，如果到达了左括号边缘，需要弹出左括号，然后入栈，并且跳出循环
        			if(stack.peek().equals("(")){
        				stack.pop(); 
        				stack.push((operation.equals("+") ? (left + right) : (left - right) )+"");
        				break;
        			}
        			else //如果没有到达左括号边缘，需要继续迭代计算。
        				stack.push((operation.equals("+") ? (left + right) : (left - right) )+"");
        		}
        	}
        	else{ //如果当前的字符是左括号，+号、-号。
        		stack.push(current+"");
        		i++;
        	}
        }
        int result=0;
        while(!stack.isEmpty()){
        	if(stack.size()==1)
        		return Integer.valueOf(stack.pop());
        	int right=Integer.valueOf(stack.pop()); //右边的值
			String operation=stack.pop(); //计算符号
			//MISTAKE (1) 如果只是单值而不是两个数组成的算式，这种情况并不能直接返回，因为有1+(5)这样的情况
			if(operation.equals("(")){
				operation=stack.pop();
			}
			int left=Integer.valueOf(stack.pop()); //左边的值
			if(!stack.isEmpty() && stack.peek().equals("-")){ //判断左边的值的符号
				left=-left;
				stack.pop();
				//MISTAKE 如果去掉了减号，需要添加一个加号，否则不满足二元运算的式子
				stack.push("+");
			}
			//MISTAKE 注意这里并不是result+=后面的值。
			result=(operation.equals("+") ? (left + right) : (left - right) );
			stack.push(result+"");
        }
        return result;
    }

}
