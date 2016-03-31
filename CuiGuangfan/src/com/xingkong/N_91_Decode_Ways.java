package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月10日 上午9:32:07 
* class description
*/
public class N_91_Decode_Ways {
	public static int numDecodings(String s) {
		if(s==null||s.trim().equals("")) return 0;
        char[] array=s.toCharArray();
        int[] result=new int[array.length+1];
        result[0]=1;
        if(array[0]!='0')result[1]=1;//起始位置判断是否为'0'
        else result[1]=0;
        for(int i=2;i<=array.length;i++){
        	//System.out.println(array[i-1]!='0'?result[i-1]:0);
        	//System.out.println(('1'<=array[i-2]&&array[i-2]<='2'&&array[i-1]<='6')?result[i-2]:0);
        	result[i]=(array[i-1]!='0'?result[i-1]:0)+(((array[i-2]=='2'&&array[i-1]<='6')||(array[i-2]=='1'&&array[i-1]<='9'))?result[i-2]:0);
        }
		return result[s.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_91_Decode_Ways.numDecodings("17"));
	}

}
