package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年1月5日 下午9:14:00 class description
 */
public class UniqueBinarySearchTrees {
	//第一种方法，利用递归计算，注意，需要避免重复计算
	public int backTrace(int i,int[]result){
		if(i==0||i==1) return 1;
		if(result[i]!=0){//避免重复计算。原来这写的是result[i]=0，即防止result[i]被重复加。但是这样会导致超时
			return result[i];
		}
		for(int j=0;j<i;j++){
			int temp1=backTrace(j,result);
			int temp2=backTrace(i-j-1,result);
			//System.out.println("backTrace("+j+")"+temp1+"*"+"backTrance("+(i-j-1)+")"+temp2);
			result[i]+=temp1*temp2;
		}
		return result[i];
	}
	public int numTrees1(int n) {
		return backTrace(n,new int[n+1]);
	}
	//第二种方法，动态规划，自动避免了重复计算
	public int numTrees(int n) {
		if(n==0) return 1;
		int[] result = new int[n+1];//这里是n+1
		result[0]=1;
		result[1]=1;
		for(int i=2;i<=n;i++){
			//result[i]=0;
			for (int j = 0; j < i; j++) {
				result[i]+=result[j]*result[i-j-1];
			}
		}
		return result[n];
		
	}
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubs=new UniqueBinarySearchTrees();
		//System.out.println(ubs.numTrees(3));
		System.out.println(ubs.numTrees1(3));
	}
}
