public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> pos = new HashMap<Character,Integer>();
        int start = -1,ret = 0;
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(pos.containsKey(c))
                start = Math.max(start,pos.get(c));
            
            pos.put(c,i);
            ret = Math.max(ret,i-start);
        }
        return ret;
    }
}
