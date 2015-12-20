package com.zyy.week3;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
	// 使用栈，还是有不满足的条件！
	// 没有理解题意，只是瞎找规律，没门！
	public String simplifyPath(String path) {
		if (path.length() == 1 && path.charAt(0) == (char) '/') {
			return "/";
		}
		Stack<String> stack = new Stack<String>();
		String sb = "";
		int flag = 0;
		for (int i = 1; i < path.length(); i++) {
			if (path.charAt(i) == (char) '/') {
				if (!sb.equals(""))
					stack.push(sb.toString());
				else {
					stack.push("/");
					// flag 记录/出现的位置
					flag = stack.size();
				}
				sb = "";
			} else {
				sb += path.charAt(i);
			}
		}
		String result = "";
		if (stack.isEmpty()) {
			return "/";
		}
		if (flag == 0) {
			result = stack.pop();
			if (result.equals("..")) {
				return "/";
			} else {
				return "/" + result;
			}
		} else {
			int count = stack.size() - flag + 2;
			while (count > 0) {
				result = stack.pop() + result;
				count--;
			}
			return "/" + result;
		}

	}

	// 理解题意：..上一级目录； . 当前目录
	public String simplifyPath1(String path) {
		Stack<String> stack = new Stack<String>();
		for (String s : path.split("/")) {
			if (s.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!s.equals(".") && !s.equals("")) {
				stack.push(s);
			}
		}
		int count = stack.size();
		if (count == 0) {
			return "/";
		}
		String str = "";
		while (count-- > 0) {
			String pop = stack.pop();
			if (!pop.equals(".."))
				str = "/" + pop + str;
			else {
				str = "/" + str;
			}
		}
		return str;

	}
	
	//别人的答案
	public String simplifyPath2(String path){
		StringBuilder sb = new StringBuilder("/");
	    LinkedList<String> stack = new LinkedList<String>();
	    for(String s: path.split("/")){
	        if(s.equals("..")){
	            if(!stack.isEmpty())
	                stack.removeLast();
	        }
	        else if(!s.equals("") && !s.equals("."))
	            stack.add(s);
	    }
	    for(String s: stack){
	        sb.append(s+"/");
	    }
	    if(!stack.isEmpty()) sb.setLength(sb.length()-1);
	    return sb.toString();
	}

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath1("/home/"));
		System.out.println(sp.simplifyPath1("/a/./b/../../c/"));
		System.out.println(sp.simplifyPath1("/home//foo/"));
		System.out.println(sp.simplifyPath1("/."));
		System.out.println(sp.simplifyPath1("/.."));
	}
}
