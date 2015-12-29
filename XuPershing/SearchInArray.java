
public class SearchInArray {

	    /**
	     * @param nums
	     * @param target
	     * @return
	     * @author xpxstar@gmail.com
	     * @2015年12月24日
	     * Given a sorted array of integers, find the starting and ending position of a given target value.
	     * Your algorithm's runtime complexity must be in the order of O(log n).
	     * If the target is not found in the array, return [-1, -1].
	     * For example,Given [5, 7, 7, 8, 8, 10] and target value 8,
	     * return [3, 4]
	     */
	    public int[] searchRange(int[] nums, int target) {
	    	/*思路：二分法。
	    	 */
	        int[] result = {-1,-1};
	        if(nums.length < 2){
	            if(nums.length == 1 && nums[0] == target){
	                result[0] = 0;
	                result[1] = 0;
	            }
	            return result;
	        }
	        if(nums[0] > target ||nums[nums.length-1] < target)
	            return result;
	        int l = 0,r = nums.length-1,mid=0;
	        while(l <= r){
	            mid = (r+l)/2;
	            if(nums[mid] == target){
	                result[0] = mid;
	                result[1] = mid;
	                while(result[0] > 0&&nums[result[0]-1]==target){
	                    result[0]--;
	                }
	                while(result[1] < nums.length-1 && nums[result[1]+1]==target){
	                    result[1]++;
	                }
	                return result;
	            }else if(nums[mid] > target){
	                r = mid-1;
	            }else{
	                l = mid+1;
	            }
	        }
	        return result;
	    }
	public static void main(String[] args) {
		int[] aa = {1,5};
		
		SearchInArray sia = new SearchInArray();
			System.out.println(sia.searchRange(aa,4));
	}

}
