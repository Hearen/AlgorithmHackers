public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer,Integer> has = new HashMap<Integer,Integer>();
        List<String> rets = new ArrayList<String>();
        if(s.length()<10) return rets;
        int x = 0;
        for(int i=8;i>=0;i--)
            x = (x<<2)+ATCG2int(s.charAt(i));
        for(int i=9;i<s.length();i++){
            x += ATCG2int(s.charAt(i))<<18;
            if(!has.containsKey(x)) has.put(x,1);
            else if(has.get(x)==1){
                has.put(x,2);
                rets.add(int2ATCG(x));
            }
            x>>=2;
        }
        return rets;
    }
    private int ATCG2int(char c){
        switch(c){
            case 'A':return 0;
            case 'T':return 1;
            case 'C':return 2;
            case 'G':return 3;
        }
        return -1;
    }
    private String int2ATCG(int x){
        StringBuffer buffer = new StringBuffer();
        char c[] = new char[]{'A','T','C','G'};
        for(int i=0;i<10;i++){
            buffer.append(c[x%4]);
            x>>=2;
        }
        return buffer.toString();
    }
}
