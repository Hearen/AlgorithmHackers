package com.zyy.week4;

public class SearchForARange {
	// 当问题比较复杂时，使用递归的方式，分离出来。
	public int[] searchRange(int[] nums, int target) {
		// 使用两次二分查找
		// 二分法的特点是找最右边的目标
		int[] result = { -1, -1 };
		// 找到的第一个target的位置
		int index = binarySearch(nums, target, 0, nums.length - 1);
		// 以此位置向左向右搜索其他的target
		if (index != -1) {
			// 以index为开始位置
			int left = index, right = index;
			result[0] = left;
			result[1] = right;
			while ((left = binarySearch(nums, target, 0, left - 1)) != -1)
				result[0] = left;
			while ((right = binarySearch(nums, target, right + 1,
					nums.length - 1)) != -1)
				result[1] = right;
		}
		// 没有找到target
		return result;
	}

	public int binarySearch(int[] nums, int target, int left, int right) {
		// 第一次先找到target的一个位置
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else
				return mid;
		}
		// 没有找到
		return -1;
	}

	// 没有成功
	public int[] searchRange1(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		if (nums.length == 1) {
			if (nums[0] == target)
				return new int[] { 0, 0 };
			else
				return new int[] { -1, -1 };

		}
		int flag = 0;
		int begin = 0, end = 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				if (mid - 1 >= 0 && nums[mid - 1] == target) {
					end = mid - 1;
					flag++;
				}
				right = mid - 1;
			} else if (nums[mid] < target) {
				if (mid + 1 < nums.length && nums[mid + 1] == target) {
					begin = mid + 1;
					flag++;
				}
				left = mid + 1;
			} else {
				if (mid + 1 < nums.length && nums[mid + 1] > target) {
					end = mid;
					flag++;
				} else if (mid - 1 >= 0 && nums[mid - 1] < target) {
					begin = mid;
					flag++;
				}
				left = mid + 1;

			}
			if (flag == 2) {
				break;
			}
		}
		if (flag == 0)
			return new int[] { -1, -1 };
		return new int[] { begin, end };
	}

	public static void main(String[] args) {
		SearchForARange srar = new SearchForARange();
		// int[] nums = { 5, 7, 7, 8, 8, 8, 10 };
		int[] nums = { 2 };
		System.out.println(srar.searchRange(nums, 1));
	}

}
