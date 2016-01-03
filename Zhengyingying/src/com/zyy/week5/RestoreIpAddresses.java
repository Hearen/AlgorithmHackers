package com.zyy.week5;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	// 动态规划
	// 一般使用递归,DFS:深度优先搜索
	public List<String> restoreIpAddresses1(String s) {
		List<String> result = new ArrayList<String>();
		restoreIp(s, result, 0, "", 0);
		return result;
	}

	public void restoreIp(String s, List<String> result, int count,
			String restored, int index) {
		if (count > 4)
			return;
		if (count == 4 && index == s.length())
			result.add(restored);
		for (int i = 1; i < 4; i++) {
			if (index + i > s.length())
				break;
			String str = s.substring(index, index + i);
			if (str.startsWith("0") && str.length() > 1
					|| Integer.parseInt(str) > 255 && i == 3)
				continue;
			restoreIp(s, result, count + 1, restored + str
					+ (count == 3 ? "" : "."), index + i);
		}

	}

	// 效率不高
	// 从给定的字符串中，找出可能的Ip地址，分成4段
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		int len = s.length();
		String s1, s2, s3, s4;
		// 第一层循环，判断IP第一段,最多检查三个，考虑到有一个情况
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < 7 && j < len - 1; j++) {
				for (int k = j + 1; k < 10 && k < len; k++) {
					s1 = s.substring(0, i);
					s2 = s.substring(i, j);
					s3 = s.substring(j, k);
					s4 = s.substring(k, len);
					StringBuilder str = new StringBuilder();
					if (isValid(s1) && isValid(s2) && isValid(s3)
							&& isValid(s4))
						result.add(str.append(s1).append(".").append(s2)
								.append(".").append(s3).append(".").append(s4)
								.toString());
				}
			}
		}
		return result;
	}

	// 判断是否可用
	public boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || s.charAt(0) == '0'
				&& s.length() > 1 || Integer.parseInt(s) > 255)
			return false;
		return true;
	}

	public static void main(String[] args) {
		RestoreIpAddresses ria = new RestoreIpAddresses();
		String s = "25525511135";
		List<String> result = ria.restoreIpAddresses1(s);
		for (String str : result) {
			System.out.println(str);
		}

	}
}
