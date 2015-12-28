
public class Pow50 {
	/**
	 * @param x
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015Äê12ÔÂ24ÈÕ
	 * Implement pow(x, n).
	 * x^n
	 */
	public double myPow(double x, int n) {
		if(n==0)return 1;
		if(x == 0)return 0;
		if(n<0){
			n=-n;
			x = 1/x;
		}
		return (n%2 ==0)?myPow(x*x, n/2):(myPow(x*x, n/2)*x);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3&1);
	}

}
