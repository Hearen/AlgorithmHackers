package week9;

public class MultiplyStrings43 {
	 public static String multiply(String num1, String num2) {
		 if (num1.equals("0")||num1.equals("-0")||num2.equals("-0")||num2.equals("0")) {
			return "0";
		 	}
	        int l1 = num1.length();
	        int l2 = num2.length();
	        boolean minus = false;
	        if(num1.charAt(0)=='-'){
	            minus = !minus;
	            num1 = num1.substring(1);
	            l1--;
	        }
	        if(num2.charAt(0)=='-'){
	            minus = !minus;
	            num2 = num2.substring(1);
	            l2--;
	        }
	        int s1 = (l1+3)/4,s2 = (l2+3)/4;
	        int[] result = new int[s1+s2];
	        int[] int1 = new int[s1];
	        int[] int2 = new int[s2];
	        int i = l1,ii=0;
	        while(i-4>0){
	            int1[ii] = Integer.valueOf(num1.substring(i-4,i));
	            i-=4;ii++;
	        }
	        int1[ii] = Integer.valueOf(num1.substring(0,i));
	        i=l2;ii=0;
	        while(i-4>0){
	            int2[ii] = Integer.valueOf(num2.substring(i-4,i));
	            i-=4;ii++;
	        }
	        int2[ii] = Integer.valueOf(num2.substring(0,i));
	        int tmp = 0;
	        for (int j = 0; j < s1+s2; j++) {
				for(int k = 0;k<=j&&k<s1; k++){
					if (k+s2 <= j) {
						continue;
					}
					tmp += int1[k]*int2[j-k];
				}
				result[j] = (int) (tmp%10000);
				tmp = tmp/10000;
			}
	        StringBuffer sb = new StringBuffer(s1+s2);
	        if (minus) {
				sb.append('-');
			}
	        int j = s1+s2-1,jj=0;
	        while(result[j]==0){
	        	j--;
	        }
	        sb.append(result[j--]);
	        for (; j >= 0; j--) {
	        	String aa = String.valueOf(result[j]);
				for (int k = 0; k < 4-aa.length(); k++) {
					sb.append('0');
				}
				sb.append(aa);
			}
	        return sb.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("140","721"));
	}

}
