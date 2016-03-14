package week8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctSubsequences115 {
	public static  boolean isHappy(int n) {
		 Set<Integer> set= new  HashSet<>();
	        set.add(n);
	        while(n!=1){
	        	System.out.println(n);
	            n = sumSquare(n);
	            if(set.contains(n)){
	                return false;
	            }
	            set.add(n);
	        }
	        return true;
	    }
    public static int sumSquare(int n){
        int sum = 0,tmp=0;
        while(n != 0){
            tmp = n%10;
            sum+=tmp*tmp;
            n/=10;
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> num = new HashMap<>();
		num.put(1,"One");
        num.put(2,"Two");
        num.put(3,"Three");
        num.put(4,"Four");
        num.put(5,"Five");
        num.put(6,"Six");
        num.put(7,"Seven");
        num.put(8,"Eight");
        num.put(9,"Nine");
        num.put(10,"Ten");
        num.put(11,"Eleven");
        num.put(12,"Twelve");
        num.put(13,"Thirteen");
        num.put(14,"Fourteen");
        num.put(15,"Fifteen");
        num.put(16,"Sixteen");
        num.put(17,"Seventeen");
        num.put(18,"Eighteen");
        num.put(19,"Nineteen");
        num.put(20,"Twenty");
        num.put(30,"Thirty");
        num.put(40,"Forty");
        num.put(50,"Fifty");
        num.put(60,"Sixty");
        num.put(70,"Seventy");
        num.put(80,"Eighty");
        num.put(90,"Ninety");
        num.put(100,"Hundred");
        String[] dd = {" Thousand"," Million"," Billion"};
        String result = "";
        int n = 12000678,i=0,tmp;
        while(n!=0){
        	tmp = n%1000;
        	if (tmp == 0) {
        		n = n/1000;
        		i++;
        		continue;
			}
        	String sub = "";
        	while(tmp!=0){
        		
            	if (tmp<21) {
            		sub +=num.get(tmp);
            		break;
    			}else if(tmp > 99){
    				sub+=num.get(tmp/100)+" "+num.get(100);
            		tmp = tmp%100;
            		if (tmp == 0) {
    					break;
    				}
    			}else {
    				sub +=" "+num.get((tmp/10)*10);
    				tmp = tmp%10;
    				if (tmp == 0) {
    					break;
    				}else
    					sub+=" ";
    			}
    		}
        	if (n/1000 > 0) {
        		
        		if("".equals(sub))
        			sub = dd[i];
        		else {
        			sub = dd[i]+" "+sub;
				}
        		i++;
        		
			}
        	result = sub+result;
        	sub="";
        	n = n/1000;
        }
        System.out.println(result);
	}
	

}
