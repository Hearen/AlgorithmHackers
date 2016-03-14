# 47. Permutations II

##Problem

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

tags:
- backtracking
- 包含重复元素的全排列

## Solution

参考：《组合数学》

- 直接生成（递归/回溯）
- 邻位互换
- 序数法
- 字典序法
- 轮转法

### 递归

参考全排列的递归公式(46 Permutations.md)，以重复元素作为前缀的均算作一个排列  
即：  

n=1 排列为自身  
n>1 P<sub>n</sub> =  iP<sub>i</sub> (i为序列中不重复的元素，P<sub>i</sub>表示以i作为前缀的全排列）

**java**
```java
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        recur(res, nums, 0, nums.length);
        return res;
    }
    
    void recur(List<List<Integer>> res, int[] nums, int begin, int end) {
        if(begin==end) {
            List<Integer> li = new ArrayList<Integer>(nums.length);
            for(Integer num:nums) {
                li.add(num);
            }
            res.add(li);
        } else {
            for(int i=begin;i<end;i++) {
                if(isSwap(nums, begin, i)) {
                    swap(nums, begin, i);
                    recur(res, nums, begin+1, end);
                    swap(nums, begin, i);
                }
            }
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]=tmp;
    }
    
    boolean isSwap(int[] nums, int begin, int end){
        for(int i=end; i>begin; i--) {
            if(nums[end]==nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}
```

### 字典序法

**字典序:**  
对于两个序列 a<sub>1</sub>...a<sub>k</sub>和b<sub>1</sub>...b<sub>k</sub>，若存在t，使得a<sub>i</sub>=b<sub>i</sub>，a<sub>t</sub> < b<sub>t</sub>,则序列  
a<sub>1</sub>...a<sub>k</sub> < b<sub>1</sub>...b<sub>k</sub>

**生成算法**

设P是1...n的一个全排列，P = P<sub>1</sub>P<sub>2</sub>...P<sub>j-1</sub>P<sub>j</sub>P<sub>j+1</sub>...P<sub>k-1</sub>P<sub>k</sub>P<sub>k+1</sub>...P<sub>n</sub>  

1. 找出j=max{i|P<sub>i</sub> < P<sub>i+1</sub>}, k=max{i|P<sub>i</sub> <=> P<sub>j</sub>}
2. 对换P<sub>j</sub>,P<sub>k</sub>
3. P<sub>j+1</sub>...P<sub>k-1</sub>P<sub>k</sub>P<sub>k+1</sub>...P<sub>n</sub>  

**未完待续。。。**