package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time：2016年3月6日 下午10:48:22 
* class description
*/
public class N_11_Container_With_Most_Water {
	public static int maxArea(int[] height) {
		int left=0;
		int right=height.length-1;
		int k=0;
		int result=0;
		while(left<right){
			int newResult=(height[left]<height[right]?height[left]:height[right])*(right-left);
			result=result>newResult?result:newResult;
			if(height[left]<height[right]){
				k=left;
				while(k<right&&height[k]<=height[left])k++;//必须是<=，比如输入的height=[1,1]，那么会导致无限循环
				left=k;
			}else{
				k=right;
				while(k>left&&height[k]<=height[right])k--;
				right=k;
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_11_Container_With_Most_Water.maxArea(new int[]{1,1}));
	}

}
