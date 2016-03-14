package leetcode_njz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _321_CreateMaximumNumber {
	
	/*
	 * You are here! Your runtime beats 2.53% of java submissions
	 */
	public  static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		if(k==0) return null;
		if(nums1==null) return nums2;
		if(nums2==null) return nums1;
		if(nums1.length==0) return nums2;
		if(nums2.length==0) return nums1;
		
		int len1 = nums1.length;
		int len2 = nums2.length;
		String maxRs = "";
		
		for(int k1=0; k1<=k; k1++){
			int k2 = k - k1;
			int[] n1 = new int[k1];
			int[] n2 = new int[k2];
			
			if(len1<k1 || len2<k2) continue;
			
			int cnt1 = 0;
			int index1 = 0;
			while(len1 >= k1 && cnt1 < k1){
				int maxIndex = index1;
				int endIndex = len1-k1+cnt1;
				if(endIndex < maxIndex) break;

				for(int i= index1+1; i<=endIndex; i++)
					maxIndex = (nums1[maxIndex] < nums1[i])? i: maxIndex;
				n1[cnt1] = nums1[maxIndex];
				index1 = maxIndex+1;
				cnt1++;
			}
			
			int cnt2 = 0;
			int index2 = 0;
			while(len2 >= k2 && cnt2 < k2){
				int maxIndex = index2;
				int endIndex = len2-k2+cnt2;
				if(endIndex < maxIndex) break;
				
				for(int i=index2+1; i<=endIndex; i++)
					maxIndex = (nums2[maxIndex] < nums2[i])?i :maxIndex;
				n2[cnt2] = nums2[maxIndex];
				index2 = maxIndex+1;
				cnt2++;
			}
			
			//整理n1和n2
			String tmp = getMax(n1, n2);
			if(maxRs.compareTo(tmp) < 1)
				maxRs = tmp;
		} 
		
		char[] s = maxRs.toCharArray();
		int[] rs = new int[k];
		for(int i=0; i<s.length; i++)
			rs[i] = s[i] - '0';
		return rs;
	}
	
	

	//n1[i] == n2[j]重点考虑
	private static String getMax(int[] n1, int[] n2) {
		int l1 = n1.length;
		int l2 = n2.length;
		String rs = "";
		
		int i=0, j=0;
		while(i<l1 && j<l2){
			if(n1[i] > n2[j]){
				rs += n1[i++];
			}else if(n1[i] < n2[j]){
				rs += n2[j++];
			}else if(n1[i] == n2[j]){
				int tmp1 = i+1;
				int tmp2 = j+1;
				while(tmp1<l1 && tmp2<l2 && n1[tmp1++] == n2[tmp2++]){}
				if(n1[tmp1-1] > n2[tmp2-1]){
					rs += n1[i++];
				}else if(n1[tmp1-1] < n2[tmp2-1]){
					rs += n2[j++];
				}else if(tmp1 == l1) {
					rs += n2[j++];
				}else if(tmp2 == l2) {
					rs += n1[i++];
				}
				
			}
		}
		
		while(i < l1)
			rs += n1[i++];
		while(j < l2)
			rs += n2[j++];
		return rs;
			
	}

	public static void main(String[] args) {
//		int[] nums1 = {3, 4, 6, 5};
//		int[] nums2 = {9, 1, 2, 5, 8, 3};
		
		int[] nums1 = {6, 7};
		int[] nums2 = {6, 0, 4};
		
//		int[] nums1 = {5, 6, 8};
//		int[] nums2 = {6, 4, 0};
		
		int k = 5;
		
		int[] rs = maxNumber(nums1, nums2, k);
		for(int i=0; i<rs.length; i++)
			System.out.print(rs[i] + " ");
	}

}
