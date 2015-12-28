
public class String2Int {
	/**
	 * @param str
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月14日
	 * Implement atoi to convert a string to an integer.
	 * Hint: Carefully consider all possible input cases. 
	 * If you want a challenge, 
	 * please do not see below and ask yourself what are the possible input cases.
	 * Notes: It is intended for this problem to be specified vaguely 
	 * (ie, no given input specs). 
	 * You are responsible to gather all the input requirements up front.
	 * Update (2015-02-10):
	 * The signature of the C++ function had been updated. 
	 * If you still see your function signature accepts a const char * argument,
	 *  please click the reload button  to reset your code definition.
	 *  spoilers alert... click to show requirements for atoi.
	 */
	public int myAtoi(String str) {
		/* edge case: 正负号、空白符、数后、超大数，超小数
		 * 
		 */
		if (null == str )return 0;
		str.trim();
		if(str.length() <1)return 0;
		
        return 0;
    }
	public static void main(String[] args) {

	}
}
