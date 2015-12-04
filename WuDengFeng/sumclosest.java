import java.util.Arrays;

public class sumclosest {
	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) return 0;
     
        Arrays.sort(num);
       
        int ret = 0;
        int closestDist = Integer.MAX_VALUE;
        int len =  num.length;
        for (int i = 0; i < len-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            
            int l = i+1, r = len-1;
            while (l < r) {
                int sum = num[i] + num[l] + num[r];
                if (sum < target) {
                    if (target-sum < closestDist) {
                        closestDist = target - sum;
                        ret = sum;
                    }
                    l++;
                } else if (sum > target) {
                    if (sum-target < closestDist) {
                        closestDist = sum - target;
                        ret = sum;
                    }
                    r--;
                } else { 
                    return sum;
                }
            }
        }
        
        return ret;
    }
	
    public static void main(String args[]){
        int result;
        int[] bArray = {1,3,3,5,6,8};
        sumclosest a=new sumclosest();
        result=a.threeSumClosest(bArray,5);
        System.out.println("result:"+result);
    }
    
}
