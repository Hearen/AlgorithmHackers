package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年3月7日 下午9:47:33 class description
 */
public class N_12_Integer_to_Roman {
	public static String intToRoman(int num) {
        String c[][]=new String[][]{{"0","I","II","III","IV","V","VI","VII","VIII","IX"},{"0","X","XX","XXX","XL","L","LX"
            ,"LXX","LXXX","XC"},{"0","C","CC","CCC","CD","D",
                "DC","DCC","DCCC","CM"},{"0","M","MM","MMM"}};
	    int t=1;
	    int tmp=num;
	    String st = "";
	    if(tmp/1000!=0) st+=c[3][tmp/1000];
	    if((tmp%1000)/100!=0) st+=c[2][(tmp%1000)/100];
	    if((tmp%100)/10!=0) st+=c[1][(tmp%100)/10];
	    if(tmp%10!=0) st+=c[0][tmp%10];
	    return st;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_12_Integer_to_Roman.intToRoman(1980));
	}

}
