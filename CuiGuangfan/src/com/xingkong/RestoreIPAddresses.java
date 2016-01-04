package com.xingkong;

import java.util.ArrayList;
import java.util.List;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2015年12月28日 下午11:08:02 
* class description
*/
public class RestoreIPAddresses {
	
	/**
	 * @version 1.0 
	 * @description 这是最初的四个for循环版本，这里把ip地址分成四块，每块进行判断，共4个for循环
	 * @param s
	 * @return 
	 */
	public static List<String> restoreIpAddresses1(String s) {
		List<String> returnList=new ArrayList<String>();
		for(int p1=1;p1<=3;p1++){
			if(p1>s.length()||Integer.valueOf(s.substring(0,p1))>255
					||(Integer.valueOf(s.substring(0,p1))+"").length()!=s.substring(0,p1).length())//去掉p1>字符串长度或者p1块的数字大于255，去掉"010的情况"
				continue;
			for(int p2=1;p2<=3;p2++){
				if(p1+p2>s.length()||Integer.valueOf(s.substring(p1,p1+p2))>255
						||(Integer.valueOf(s.substring(p1,p1+p2))+"").length()!=s.substring(p1,p1+p2).length())
					continue;
				for(int p3=1;p3<=3;p3++){
					if(p1+p2+p3>s.length()||Integer.valueOf(s.substring(p1+p2,p1+p2+p3))>255
							||(Integer.valueOf(s.substring(p1+p2,p1+p2+p3))+"").length()!=s.substring(p1+p2,p1+p2+p3).length())
						continue;
					for(int p4=1;p4<=3;p4++){
						if(p1+p2+p3+p4!=s.length()||Integer.valueOf(s.substring(p1+p2+p3,p1+p2+p3+p4))>255
								||(Integer.valueOf(s.substring(p1+p2+p3,p1+p2+p3+p4))+"").length()!=s.substring(p1+p2+p3,p1+p2+p3+p4).length())
							continue;
						returnList.add(s.substring(0,p1)+"."+s.substring(p1,p1+p2)+"."
								+s.substring(p1+p2,p1+p2+p3)+"."+s.substring(p1+p2+p3,p1+p2+p3+p4));
						System.out.println(s.substring(0,p1)+"."+s.substring(p1,p1+p2)+"."
							+s.substring(p1+p2,p1+p2+p3)+"."+s.substring(p1+p2+p3,p1+p2+p3+p4));
					}
				}
			}
		}
		return returnList;
        
    }
	/**
	 * @version 2.0 
	 * @description 这里将for循环改成递归形式（比for循环实现更慢~）
	 * @param s
	 * @return 
	 */
	public static  List<String> testList=new ArrayList<String>();
	public static  List<String> tempList=new ArrayList<String>();
	public static String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(".");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }
	public static void backTrace(String s,int psum,int depth){
		if(depth>4||psum>s.length()) return;
		if(depth==4){
			if(psum!=s.length()) return;
			System.out.println(listToString(tempList));
			testList.add(listToString(tempList));
		}
		for(int p=1;p<=3;p++){
			if(psum+p>s.length()||Integer.valueOf(s.substring(psum,psum+p))>255||
					(Integer.valueOf(s.substring(psum,psum+p))+"").length()!=s.substring(psum,psum+p).length())
				continue;
			tempList.add(s.substring(psum,psum+p));
			backTrace(s,psum+p,depth+1);
			tempList.remove(tempList.size()-1);//删掉刚刚加入的
		}
	}
	public static List<String> restoreIpAddresses2(String s) {
		backTrace(s,0,0);
        return testList;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses.restoreIpAddresses2("25525511135");
	}

}
