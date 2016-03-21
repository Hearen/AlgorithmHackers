package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月1日 下午5:23:15 
* class description
*/
public class N_319_Bulb_Switcher {
	/**
	 * 思路：刚开始，第i个位置，i会被第1遍toggle，会被第i遍toggle，会被i的所有m*n和n*m toggle，偶数个toggle并不会改变灯的状态（最后还是关闭），只有奇数个toggle会让灯
	 * on，会让toggle次数变为奇数的情况当且只有j*j==i的情况，那么，我们会得出，所有开启的灯的index都存在j*j==index，所以出现下方这个函数，我们发现，其实，
	 * 这个for循环就是求(int)sqrt(n)的值，所以，只用一行就解决了。
	 */
	public static int bulbSwitch(int n) {
		//if(n==1) return 1;
//		int[]isPrime=new int[n+1];
//		isPrime[1]=1;
//        for(int i=2;i<=n;i++)
//        	isPrime[i]=0;
		int count=0;
        for(int i=1;i*i<=n;i++){
        	//if(isPrime[i]==0) continue;
//        	isPrime[i*i]++;
        	count++;
//        	for(int j=i*i;j<=n;j+=i){
//        		if(j==i*i){
//        			isPrime[j]++;
//        		}
//        	}
        }
//        int count=0;
//        for(int i=1;i<=n;i++){
//        	if(isPrime[i]%2==0) count++;
//        }
        return count;
    }
	public static int bulbSwitchBetter(int n) {
		return (int)Math.sqrt(n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_319_Bulb_Switcher.bulbSwitch(4);
	}

}
