package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年2月29日 下午10:34:31
 * @content 
 */

public class _043_Multiply_Strings {
	
	public static void main(String args[]){
		_043_Multiply_Strings test = new _043_Multiply_Strings();
		String nums1="0";
		String nums2="52";
		System.out.println(test.add(nums1, nums2));
		System.out.println(test.multiply(nums1, nums2));
	}
	
	// abc * defg 需要做四次乘法运算，四次加法运算
	public String multiply(String nums1,String nums2){
		String res = "",temp = "";
		//交换
		changeIfNecy(nums1,nums2);
		for(int i=nums2.length()-1;i>=0;i--){
			temp = multiplySingle(nums1,nums2.charAt(i)+"");
			if(!temp.equals("0")){
				for(int k=0;k<nums2.length()-1-i;k++)
					temp+="0";
			}
			res=add(res,temp);
		}
		return res;
	}
	
	private String multiplySingle(String nums,String single){
		if("0".equals(single)) return "0";
		String res = "";
		int carry = 0, left = 0, temp =0;
		int p = nums.length()-1;
		while(p>=0){
			temp = Integer.parseInt(nums.charAt(p)+"") * Integer.parseInt(single) + carry ;
			carry = temp / 10;
			left = temp % 10;
			res = Integer.toString(left) + res;
			p--;
		}
		return carry > 0 ? Integer.toString(carry) + res : res;
	}
	
	public void changeIfNecy(String nums1,String nums2){
		if(nums1.length()<nums2.length()){
			String temp = nums2;
			nums2 = nums1;
			nums1 = temp;
		}
	}
	
	//两个无穷大整数的加法
	public String add(String nums1,String nums2){
		String res = "";
		//每次将加的结果放在最后一位，两个指针，从后往前移动 
		int carry = 0, left = 0, temp=0; //进位和余数
		int p1=nums1.length()-1, p2=nums2.length()-1;
		while(p1>=0 || p2>=0){
			if(p1>=0 && p2>=0){
				temp = Integer.parseInt(nums1.charAt(p1)+"") + Integer.parseInt(nums2.charAt(p2)+"") + carry;
				p1--;p2--;
			}
			else if(p1>=0 && p2<0){
				temp = Integer.parseInt(nums1.charAt(p1)+"")  + carry;
				p1--;
			}
			else {
				temp = Integer.parseInt(nums2.charAt(p2)+"") + carry;
				p2--;
			}
			carry = temp / 10;
			left = temp % 10;
			res=Integer.toString(left)+res;
		}
		return  carry>0 ? "1"+res : res;
	}

}
