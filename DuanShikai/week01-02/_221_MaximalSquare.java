package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2015年12月13日 下午8:54:45
 * @content 
 */

public class _221_MaximalSquare {
	
	public static void main(String args[]){
		char[][] matrix={{'1'}};
		//char[][] matrix={{'1','1','1','1','1','1','0','1'},{'1','1','1','0','1','0','1','0'}};
		System.out.println(maximalSquare(matrix));
	}
	
	/*
	 * 采用动态规划的思想。
	 * 假设以matrix[i][j]为右下角形成的最大的正方形的变长为a,简记为f(i,j)=a;
	 * 如果 matrix[i][j]=='0',显然有 f(i,j)=0;
	 * 如果matrix[i][j]=='1',那么
	 * f(i,j)=min{f(i-1,j),f(i,j-1),f(i-1,j-1)}+1;
	 * 该公式是根据
	 * f(i,j)=min{min{f(i-1,j),f(i-1,j-1)},min{f(i,j-1),f(i-1,j-1)}}
	 * 简化而来。（画出示意图就很明显了）
	 */

	public static int maximalSquare(char[][] matrix){
		int result=0;
		if(matrix.length==0) return result;
		int height=matrix.length;int width=matrix[0].length;
		int[][] f=new int[height][width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				//初始化第一行或者第一列的值
				if((i==0 || j==0) || matrix[i][j]=='0')
					f[i][j]=matrix[i][j]=='1' ? 1 : 0;
				else
					f[i][j]=Math.min(Math.min(f[i-1][j], f[i-1][j-1]),f[i][j-1])+1;
				if(f[i][j]>result)
					result=f[i][j];
			}
		}
		return result*result;
	}
	
	
	public static int maximalSquare_wrong_solution(char[][] matrix) {
        if(matrix==null) return 0;
        if(matrix.length<=1 || matrix[0].length<=1) return matrix.length;
        int result=0;
        int height=matrix.length; int width=matrix[0].length;
        int start=0;int end=0;
        for(int i=0;i<height;i++){
        	/*
        	 * 找到这一行的所有连续的1的坐标。
        	 * 例如 1 1 1 0 1 1 1 1 1 0 1 0 1 0 1 1 
        	 * (1,3)(5,9)(11,11)(13,13)(15,16)
        	 */
        	Queue<Integer> queue=new LinkedList<Integer>();
        	for(int j=0;j<width;j++){
        		while(j<width && matrix[i][j]!='1') j++;
        		if(j==width){//到达最后一行，而且最后一个元素是0
        			break;
        		}
        		start=j;
        		while(j<width && matrix[i][j]!='0') j++;
        		end=j-1;
        		queue.add(start);queue.add(end);
        	}
        	/*
        	 * 现在开始检索每一种情况是否是正方形。
        	 * 之前存在的思维漏洞是 如果在队列中检索出3-5是连续的1，那么检测
        	 * 从该行开始到接下来的三行，对应的数字是否是1.这显然不对，因为可能是
        	 * 3-5的子集，即3-4可能是矩形，而3-5不是矩形。
        	 * 如果去遍历3-5所有的子集，这样算法的复杂度就太高了。这种方法思路有问题。
        	 */
        	while(!queue.isEmpty()){
        		start=queue.poll();
        		end=queue.poll();
        		boolean find=true;
        		for(int ii=start;ii<=end;ii++){
        			if(i+end-start>height){
        				find=false;
        				break;
        			}
        			for(int jj=i;jj<=i+end-start;jj++){
        				if(matrix[jj][ii]=='0'){
        					find=false;
        					break;
        				}
        			}
        			if(!find){
        				break;
        			}
        		}
        		if(find){
        			if(end-start+1>result)
        				result=end-start;
        		}
        	}
        	
        	
        }
        
        
        return result;
    }

}
