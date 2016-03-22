package com.xingkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月16日 上午8:38:48 
* class description
*/
public class N_17_Letter_Combinations_of_a_Phone_Number {
	Map<String,List<String>> resultMap=new HashMap<String,List<String>>();
	Map<String,List<String>> dictMap=new HashMap<String,List<String>>();
	private void init(){
		dictMap.put("2", Arrays.asList(new String[]{"a","b","c"}));
		dictMap.put("3", Arrays.asList(new String[]{"d","e","f"}));
		dictMap.put("4", Arrays.asList(new String[]{"g","h","i"}));
		dictMap.put("5", Arrays.asList(new String[]{"j","k","l"}));
		dictMap.put("6", Arrays.asList(new String[]{"m","n","o"}));
		dictMap.put("7", Arrays.asList(new String[]{"p","q","r","s"}));
		dictMap.put("8", Arrays.asList(new String[]{"t","u","v"}));
		dictMap.put("9", Arrays.asList(new String[]{"w","x","y","z"}));
	}
	public List<String> letterCombinations(String digits) {//我这道题做麻烦了
		if(dictMap.isEmpty()) init();
		List<String> list=new ArrayList<String>();
		if(digits.trim().equals(""))
			return list;
		if(resultMap.containsKey(digits))
			return resultMap.get(digits);
		//for(int i=0;i<digits.length();i++){
			String tempStr=digits.substring(0,1);
			List<String> tempList=letterCombinations(digits.substring(1));
			List<String> mapStr=dictMap.get(tempStr);
			for(String tempMapStr:mapStr){
				if(tempList.isEmpty()){
					//if(i==digits.length()-1)
						list.add(tempMapStr);
				}else{
					for(String temp:tempList){
						list.add(tempMapStr+temp);
					}
				}
			}
		//}
		resultMap.put(digits, list);
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_17_Letter_Combinations_of_a_Phone_Number n=new N_17_Letter_Combinations_of_a_Phone_Number();
		System.out.println(n.letterCombinations("23"));
	}

}
