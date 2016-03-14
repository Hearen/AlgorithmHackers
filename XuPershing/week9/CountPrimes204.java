package week9;

public class CountPrimes204 {
	public static int countPrimes(int n) {
		boolean[] iPrime = new boolean[n];
		int size = (int) Math.sqrt(n);
		for (int i = 2; i <= size; i++) {
			if (iPrime[i]) continue;
		    for (int j = i * i; j < n; j += i) {
		         iPrime[j] = true;
		    }
		}
		int result = 0 ;
		for (int i = 2; i < n; i++) {
			result+=iPrime[i]?0:1;
		}
		return result;
	}
	public static int countPrimesI(int n) {
		int result = 0 ;
		for (int i = 2; i <= n; i++) {
			result+=isPrimes(i);
		}
		return result;
	}
	public static int isPrimes(int n) {
		int f = 2,opf = (int) Math.sqrt(n);
		while(f<=opf){
			if (n%f == 0) {
				return 0;
			}
			f++;
		}
		return 1;
    }
	public static void main(String[] args) {
		System.out.println(countPrimes(1500000));
	}
}
