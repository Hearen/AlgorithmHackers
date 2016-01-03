import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetII90 {
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月28日
	 * Given a collection of integers that might contain duplicates, nums, 
	 * return all possible subsets.Note:
	 * Elements in a subset must be in non-descending order.
	 * The solution set must not contain duplicate subsets.
	 * For example,
	 * If nums = [1,2,2], a solution is:
	 * 
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		/* 思路：首先排序。先计算1个元素可以生成的集合，再将所有集合依次添加第二个元素，生成2个元素可生成的集合，然后第3、4...
		 * 
		 * 最终生成所有可能的集合。
		 * 
		 */
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length <1) {
			return result;
		}
		Arrays.sort(nums);
		Set<List<Integer>> resultSet = new HashSet<>();
		resultSet.add(new ArrayList<Integer>());
		subsetsWithDup(resultSet,nums,0);
		result.addAll(resultSet);
		return result;
    }
	public void subsetsWithDup(Set<List<Integer>> result,int[] nums,int start) {
		if (start == nums.length) {
			return ;
		}
		Set<List<Integer>> added = new HashSet<>();
		for(List<Integer> tmp:result){
			List<Integer> single = new ArrayList<>(tmp);
			single.add(nums[start]);
			added.add(single);
		}
		result.addAll(added);
		subsetsWithDup(result,nums,start+1);
    }
	
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月29日
	 * Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
	 */
	public List<List<Integer>> subsets(int[] nums) {
		/* 思路：首先排序。先计算1个元素可以生成的集合，再将所有集合依次添加第二个元素，生成2个元素可生成的集合，然后第3、4...
		 * 最终生成所有可能的集合。
		 */
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length <1) {
			return result;
		}
		Arrays.sort(nums);
		result.add(new ArrayList<Integer>());
		subsets(result,nums,0);
		return result;
    }
	public void subsets(List<List<Integer>> result,int[] nums,int start) {
		if (start == nums.length) {
			return ;
		}
		int size = result.size();
		for(int i = 0;i<size;i++){
			List<Integer> single = new ArrayList<>(result.get(i));
			single.add(nums[start]);
			result.add(single);
		}
		subsets(result,nums,start+1);
	}
	
	public static void main(String[] args) {
		int[] nums  = {4,2,2};
		List<List<Integer>> r = new SubsetII90().subsetsWithDup(nums);
		for(List<Integer> tmp :r){
			for(int i : tmp){
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
