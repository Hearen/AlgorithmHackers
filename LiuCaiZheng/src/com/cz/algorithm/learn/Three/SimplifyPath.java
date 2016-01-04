package com.cz.algorithm.learn.Three;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 * 
 * */
public class SimplifyPath {

	public static void main(String[] args) {
		String s = "/a/./b/../../c/";
		System.out.println(new SimplifyPath().simplifyPath(s));
	}

	public String simplifyPath(String path) {

		if (path == null || path.length() == 0)
			return "";
		Stack<String> stack = new Stack<String>();
		Stack<String> pathStack = new Stack<String>();
		path = path.substring(1, path.length() - 1);
		System.out.println(path);
		String[] pathArray = path.split("/");
		int len = pathArray.length;
		String returnPath = "";
		for (int i = 0; i < len; i++) {
			if(pathArray[i].equals("..")) {
				stack.push(pathArray[i]);
			} else if(pathArray[i].equals(".")) {
				continue;
			} else {
				while(!stack.empty()) {
					
				}
			}
		}
		return null;
	}
}
