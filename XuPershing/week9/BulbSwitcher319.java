package week9;

public class BulbSwitcher319 {
	public static int bulbSwitch(int n) {
		return (int)Math.sqrt(n);
    }
	public static int countFactor(int n){
		if (n == 1) {
			return 0;
		}
		int f = 2,opf = n,c = 0;
		while(f<opf){
			if (n%f == 0) {
				opf = n/f;
				
				c+=2;
				if (f == opf) {
					return c;
				}
			}
			f++;
		}
		return ++c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bulbSwitch(99999));
	}
}
