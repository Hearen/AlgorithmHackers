package com.josh.task8;

import org.junit.Test;

public class UniqueBinarySearchTrees {
	@Test
	public void test(){
		System.out.println(numTrees2(3));
	}
	//卡特兰数解法
    public int numTrees(int n) {
        long[] c = new long[n+1];
        c[0] = 1;
        for(int i=1;i<n+1;i++){
        	c[i] = (4*i-2)*c[i-1]/(i+1);
        }
    	return new Long(c[n]).intValue();
    }
    /*
     * 动态规划解法
     * 当前根节点为i，那么1到i-1为跟节点i的左子树，i+1到n为跟节点i的右子树
     * 假设左子树有m中排列方式，右子树有n中排列方式，那么跟节点i的数目为m*n个
     * 注：若m=0或者n=0，则i的个数即为m的个数或者n的个数[所以初始化res0=1，保证公式一致]
     * 初始状态：res[0]=1,res[1]=1
     * 递推公式：res[i]=res[i] + res[j]*res[i-j-1]
     * 
     */
  
    /*
     * 初始化 初始状态：res[0]=1
     * e.g.n=1 以1位跟节点：比1小的左子树0个，比1大的右子树均为0个，res[1]=res[0]*res[0]，res[1]=sum(res[1])
     * 	   n=2  以1为跟节点：比1小的左子树0个，比1大的右子树均为1个，res[2]=res[0]*res[1]
     * 		       以2为跟节点：比2小的左子树1个，比2大的右子树均为0个，res[2]=res[1]*res[0]，res[2]=sum(res[2])
     *     n=3 以1为跟节点：比1小的左子树0个，比1大的右子树均为2个，res[2]=res[0]*res[2]
     * 		        以2为跟节点：比2小的左子树1个，比2大的右子树均为1个，res[2]=res[1]*res[1]
     *         以3为跟节点：比3小的左子树2个，比1大的右子树均为0个，res[2]=res[2]*res[0]，res[3]=sum(res[3])
     *     ………
     */
    public int numTrees2(int n) {
    	if(n<=0)  return 0;  
    	int[] res = new int[n+1];  
    	res[0] = 1;  
    	res[1] = 1;  
    	for(int i=2;i<=n;i++){
    		for(int j=1;j<=i;j++){
    			res[i]+=res[j-1]*res[i-j];
    		}
    	}
    	return res[n];
    }
}
