package com.josh.task7;
import org.junit.Test;

/*
 * 给定一个非负数组，数组中的元素代表从当前位置可以移动的最大步数
 * 初始化位置0
 */
public class JumpGameII {

	@Test
	public void test(){
		int[] nums = {1,1,1,0};
		int i = jump(nums);
		System.out.print(i);
		boolean b = canJump(nums);
		System.out.println(b);
	}
	//Jump Gam II
	/*
	 * 求到达数组末尾的最少步数
	 * 分析：从开始位置寻找可到达最远距离的下一个点
	 * 	        直观来看从开始位置能到达的最远距离位置为：开始位置索引+开始位置的元素值=最远位置索引
	 *     但事实不是这样，我们还要遍历"开始位置"到"开始位置索引+开始元素值"位置之间的所有元素
	 *     看他们能到达的最远距离是否比"最远位置索引"远，若远则以当前位置为下一个开始位置
	 */
    public int jump(int[] nums) {
    	int steps = 1;
    	if(nums.length == 0 || nums.length == 1) return 0;
    	if(nums[0]>=(nums.length-1)) return 1;
    	return findPosi(nums, 0, steps);    
    }
    public int findPosi(int[] nums ,int start,int steps){
    	while(start + nums[start]<nums.length-1){
    		int end = start + nums[start];
    		int maxLen = end+nums[end];//start下一步可到达的最远距离
    		for(int i=start;i<=end;i++){
        		if((i+nums[i])>=maxLen){
        			maxLen = i+nums[i];
        			start = i;
        		}
        	}
    		steps++;
    	}
    	return steps;
    }
    //Jump Gam I
    //数组末尾是否可达
    /*分析：
     * 不可达位置一定是在0处出现，所以遍历数组，若没有0，则必然可达
     * 若有0，从0位置开始判断，之前各点是否可以经过0，若不可经过，则表示不可达，若可经过，可达
     * 
     */
    public boolean canJump(int[] nums) {
    	if(nums.length == 0) return false;
    	if(nums.length == 1 || nums[0]>=(nums.length-1)) return true;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i] == 0 && i!=nums.length-1){
    			boolean flag = false;//检查0之前的位置上的元素是否可以经过0位置,如果不能经过，list.add(i)；
    			for(int j=i;j>=0;j--){
    				if(j+nums[j]>i+nums[i]){
    					flag = true;
    					break;//可以经过0位置，跳出循环
    				}
    			}
    			if(flag == false) return false;
    		}
    	}
    	return true;
    }
}
