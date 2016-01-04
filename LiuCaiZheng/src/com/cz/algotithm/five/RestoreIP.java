package com.cz.algotithm.five;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestoreIP {

	public static void main(String[] args) {
		String s  = "25525511135";
		List<String> result =  new RestoreIP().restoreIpAddresses(s);
		for(String rs : result) {
			System.out.println(rs);
		}
	}
	 public List<String> restoreIpAddresses(String s) {
	      if(s == null  | s.length() == 0 )  return null;
          int len = s.length();
          List <String> lists  = new ArrayList<String>();
          if(len  == 12) {
        	  String st = s.substring(0, 3) + "." + s.substring(3,6) + "." + s.substring(6,9) + "." + s.substring(9,12);
        	  lists.add(st);
          } else if (s.length() < 3){ 
        	  
          }else {
        	  
          } 
	      return null;
	   }
}
