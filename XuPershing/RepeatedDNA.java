import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedDNA {
	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
	/**
	 * @param s
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月14日
	 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
	 * for example: "ACGAATTCCG". When studying DNA, 
	 * it is sometimes useful to identify repeated sequences within the DNA.
	 * Write a function to find all the 10-letter-long sequences (substrings)
	 * that occur more than once in a DNA molecule.
	 * For example,Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
	 * Return:["AAAAACCCCC", "CCCCCAAAAA"].
	 */
	char[] dna={'A','C','G','T'};
	public List<String> findRepeatedDnaSequences(String s) {
		/*思路： 比较字符串是很麻烦的，现在4个DNA碱基转换成00,01,10,11四个二进制数，那么10个碱基的串就可以用一个正整数表示，
		 * 比如0表示10个A等
		 * 这样将所有长度为10 的串转换成lenth-9的数组，判断数组是否有重复就是子串是否有重复，这个是比较容易的，
		 * 找到重复数后，还需要转换回来。
		 * */
		List<String> result = new ArrayList<>();
		if (s.length() < 11) {
			return result;
		}
		int[] newChar = parser(s);
		Arrays.sort(newChar);
		for(int i = 9;i < s.length()-1;){
			int j=i+1;
			if (newChar[i] == newChar[j]) {
				result.add(reParser(newChar[i]));
			}
			while(j<s.length() && newChar[i] == newChar[j]){
				j++;
			}
			i = j;
		}
		return result;
        
    }
	private String reParser(int chars){
		char[] sub = new char[10];
		for(int i = 9;i>=0;i--){
			sub[i] = dna[chars&3];
			chars = chars>>2;
		}
		return String.valueOf(sub);
	}
	private int[] parser(String s){
		int[] newChar = new int[s.length()];
		int tmp = 0;
		for(int i = 0;i<s.length();i++){
			switch (s.charAt(i)) {
			case 'A':
				tmp = tmp<<2;
				break;
			case 'C':
				tmp = tmp<<2;
				tmp+=1;
				break;
			case 'G':
				tmp = tmp<<2;
				tmp+=2;
				break;
			case 'T':
				tmp = tmp<<2;
				tmp+=3;
				break;
			default:
				break;
		}
		newChar[i] = (tmp&1048575);//0xFFFFF
		}
		for(int i = 0;i<9;i++){
			newChar[i] = 0;
		}
		return newChar;
	}
	public static void main(String[] args ){
		RepeatedDNA rd = new RepeatedDNA();
		for (String string : rd.findRepeatedDnaSequences(rd.s)) {
			System.out.println(string);
		}
	}
}
