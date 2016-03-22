package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月5日 下午7:38:57 
* class description
*/
public class N_8_String_to_Integer {
	public static int myAtoi(String str) {
		str=str.trim();
		boolean negative=false;
		int i=0;
		int limit=-Integer.MAX_VALUE;
		int radix=10;
		int result = 0;
        if(str.length()>0){
        	char firstChar=str.charAt(0);
        	if(firstChar<'0'){
        		if(firstChar=='-'){
        			negative=true;
        			limit=Integer.MIN_VALUE;
        		}else if(firstChar!='+'){
        			return 0;
        		}
        		if(str.length()==1){
        			return 0;
        		}
        		i++;
        	}
        	int multmin=limit/radix;
        	int digit=0;
        	while(i<str.length()){//不管是正数还是负数，都用一样的办法（-），因为负数比正数多，这样，负数部分更好处理
        		digit=Character.digit(str.charAt(i++), radix);
        		if(digit<0) 
        			return negative?result:-result;
        		if(result<multmin){//如果result>=multmin，那么如果下面result*=radix，会overflow
        			return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        		}
        		result*=radix;
        		if(result<limit+digit){//防止下一步的result-=digit越界
        			//不能写成result-digit<limit，否则结果是错的，比如输入-2147483649的时候
        			//因为如果输入-2147483649，那么，解析到result=-214748364时，再-digit，会造成越界，变成了正数
        			return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        		}
        		result-=digit;
        	}
        }else{
        	return 0;
        }
        return negative?result:-result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_8_String_to_Integer.myAtoi("-2147483649"));
		//System.out.println(Integer.valueOf("-2147483649"));
	}

}
