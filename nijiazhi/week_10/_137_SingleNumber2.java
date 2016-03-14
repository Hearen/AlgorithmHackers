package leetcode_njz;

//	除了一个数，其他的都出现3次
public class _137_SingleNumber2 {
	
	/*
	 * 通用的方法---还可以计算出现2次、3次的情况
	 * 
	 * 用一个int[32]记录每一位出现的次数，
	 * 两个for循环，其中一个是32次循环，常数次循环。
	 */
	public static int singleNumber1(int[] nums) {
	     if(nums == null || nums.length == 0)
	    	 return 0;
	     
	     int[] flag = new int[32];
	     int rs = 0;
	     for(int i=0; i<32; i++){
	    	 for(int j=0; j<nums.length; j++){
	    		 int tmp = (nums[j]>>i) & 1;
	    		 flag[i] += tmp;
	    	 }
//	    	 flag[i] %= 3;
	    	 rs += (flag[i]%3)<<i;
	     }
	     
//	     for(int i=0; i<32; i++){
//	    	 rs += flag[i] << i;
//	     }
	     return rs;
	}
	
	/*
	 * 效率更高的算法，可以使用三个变量记录每次的结果
	 * note：善于使用位的运算
	 */
	public static int singleNumber(int[] nums) {
	     if(nums == null || nums.length == 0)
	    	 return 0;
	     
	     int[] flag = new int[32];
	     int rs = 0;
	     for(int i=0; i<32; i++){
	    	 for(int j=0; j<nums.length; j++){
	    		 int tmp = (nums[j]>>i) & 1;
	    		 flag[i] += tmp;
	    	 }
	    	 rs += (flag[i]%3)<<i;
	     }
	     
	     return rs;
	}
	
	public static void main(String[] args) {
		int test1 = 0;
		int test2 = 6;
		int test3 = 5;
		int test_rs = test1 ^ test2;
		System.out.println("test-异或运算：" + test_rs);
		
		int[] nums = {1,1,2,1,2,2,3,3,4,4,4,3,5,5,6,6,5,67,6};
		int rs = singleNumber1(nums);
		System.out.println("rs : " + rs);
	}

}
