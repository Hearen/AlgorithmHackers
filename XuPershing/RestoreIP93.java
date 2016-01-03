import java.util.ArrayList;
import java.util.List;

import javax.tools.ToolProvider;

public class RestoreIP93{
	/**
	 * @param s
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月28日
	 * Given a string containing only digits, 
	 * restore it by returning all possible valid IP address combinations.
	 * For example:Given "25525511135",
	 * return ["255.255.11.135", "255.255.111.35"]. 
	 * (Order does not matter)
	 */
	public List<String> restoreIpAddresses(String s) {
		/*思路：暴力法，用i[]记录前三个数的长度,
		 * 那么i最的范围是1，2，3。所以就有3*3*3=27种分法，
		 * 这样，只要判断这样生成的ip是否合法即可，
		 * 还可以继续剪枝，当某一个数，大于255时就宣布下面的i失败，可以减少遍历次数
		 * 其他判断条件还有当前数位数大于1，且第一个数是0,这是不合法的 
		 * 当前的总长度越界，
		 * 最后一个数的位数大于3，或者小于1；
		 */
		 List<String> result = new ArrayList<>();
	        if(null == s ||s.length() <4){
	            return result;
	        }
	    int size = s.length();
        int current = 0;
        int[] i = {1,1,1};
        for(; i[0]<4;i[0]++){
        	if (Integer.valueOf(s.substring(0,i[0])) > 255) {
				break;
			}
        	if(i[0]>1 && s.charAt(0)=='0'){
    			break;
    		}
        	for(i[1]=1; i[1]<4;i[1]++){
        		current=i[0]+i[1];
        		if (current > size-2) {
					break;
				}
        		if (Integer.valueOf(s.substring(i[0],current)) > 255) {
					break;
				}
        		if(i[1]>1 && s.charAt(i[0])=='0'){
        			break;
        		}
        		for(i[2]=1; i[2]<4;i[2]++){
        			current = i[0]+i[1]+i[2];
        			if (current < size-3) {
						continue;
					}
        			if (current >size-1) {
						break;
					}else if(current < size-1 &&s.charAt(current)=='0'){
						continue;
					}
        			if (Integer.valueOf(s.substring(i[0]+i[1],current)) > 255) {
    					break;
    				}
        			if(i[2]>1 && s.charAt(i[0]+i[1])=='0'){
            			break;
            		}
        	       	if (current < size) {
						int last = Integer.valueOf(s.substring(current));
						if(last < 256 ) {
							StringBuffer sb = new StringBuffer();
							sb.append(s.substring(0, i[0]));
							sb.append("."+s.substring(i[0], i[0]+i[1]));
							sb.append("."+s.substring(i[0]+i[1], i[0]+i[1]+i[2]));
							sb.append("."+s.substring(i[0]+i[1]+i[2]));
							result.add(sb.toString());
						}
					}
                }
            }
        }
        return result;
    }
	public List<String> restoreIpAddressesBK(String s) {
		/*思路：暴力法，用i[]记录三个点的位置（数组某数index的前面）,
		 * 那么i[0]最的范围是1，2，3,i[1]的是i[0]+1,2,3,i[2]就是i[1]+1,2,3。
		 * 所以就有3*3*3=27种分法，其实和第一个方法类似
		 * 这样，只要判断这样生成的ip是否合法即可，
		 * 还可以继续剪枝，当某一个数，大于255时就宣布下面的i失败，可以减少遍历次数
		 * 其他判断条件还有当前数位数大于1，且第一个数是0,这是不合法的 
		 * 当前的总长度越界，
		 * 最后一个数的位数大于3，或者小于1；
		 */
		List<String> result = new ArrayList<>();
	    if(null == s ||s.length() <4||s.length() > 12){
	        return result;
	    }
	    int size = s.length();
        int[] i = {0,0,0};
        for(i[0]=1; i[0]<4;i[0]++){
        	if(i[0] > size-3||(i[0]>1 && s.charAt(0)=='0')||Integer.valueOf(s.substring(0,i[0])) > 255) {
				break;
			}
        	if (i[0] < size-9) {
				continue;
			}
        	for(i[1]=i[0]+1; i[1]<i[0]+4;i[1]++){
        		if (i[1] > size-2 ||(i[1]-i[0]>1 && s.charAt(i[0])=='0')||Integer.valueOf(s.substring(i[0],i[1])) > 255) {
					break;
				}
        		if (i[1] < size-6) {
        			continue;
        		}
        		for(i[2]=i[1]+1; i[2]<i[1]+4;i[2]++){
        			if (i[2] >size-1||(i[2]-i[1]>1 && s.charAt(i[1])=='0')||Integer.valueOf(s.substring(i[1],i[2])) > 255) {
						break;
					}
        			if (i[2] < size-3||(i[2] < size-1 &&s.charAt(i[2])=='0')) {
						continue;
					}
					int last = Integer.valueOf(s.substring(i[2]));
					if(last < 256 ) {
						StringBuffer sb = new StringBuffer();
						sb.append(s.substring(0, i[0]));
						sb.append("."+s.substring(i[0], i[1]));
						sb.append("."+s.substring(i[1], i[2]));
						sb.append("."+s.substring(i[2]));
						result.add(sb.toString());
					}
                }
            }
        }
        return result;
    }
	/*private int getValid(int start,String s,int n){
		int result = 0;
		if (n == 0) {
			int last = Integer.valueOf(s.substring(start));
			if(last < 256 ){
				System.out.println("."+last);
				return last;
			}else {
				return -1;
			}
		}else {
			if(start <s.length()-1 &&(result =getValid(start+1, s, n-1)) !=-1){
				System.out.println("."+s.substring(start, start+1));
			}
			if(start <s.length()-2 &&(result =getValid(start+2, s, n-1)) !=-1){
				System.out.println("."+s.substring(start, start+2));
			}
			if(start <s.length()-3 ){
				int tmp = Integer.valueOf(s.substring(start,start+3));
				if (tmp < 256) {
					if ((result=getValid(start+3, s, n-1)) != -1){
						System.out.println("."+s.substring(start, start+3));
					}
				}
			}
		}
		return -1;
	}*/
	public static void main(String[] args) {
		new RestoreIP93().restoreIpAddressesBK("010010");
	}

}
