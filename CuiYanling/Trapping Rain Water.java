public class Solution {
    public int trap(int[] height) {
        int water = 0,len = height.length;
        if(len<=2) return 0;
        int high[] = new int[len]; //记录i~height-1最大的数的索引
        high[len-1] = len-1;
        for(int i=len-2;i>=0;--i)
            if(height[high[i+1]]>=height[i]) high[i] = high[i+1];
            else high[i]=i;
        
        for(int i=0;i<len;){
            for(;i<len-1&&height[i]<=height[i+1];++i);
            if(i>=len-2) break;
            if(height[high[i+1]]<=height[i]){
                for(int j=i+1;j<high[i+1];++j)
                    water+=height[high[i+1]]-height[j];
                i=high[i+1];
            }else{
                int lefth = height[i];
                for(++i;i<len&&height[i]<=lefth;++i)
                    water+=lefth-height[i];
            }
        }
        return water;
    }
}
