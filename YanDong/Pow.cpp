class Solution {
public:
    //¶þ·ÖÇóÃÝ
    double myPow(double x, int n) {
        if(x == 0) return 0;
        double ret = 1;
        bool isNegative = false;
        if(n < 0 ){
             isNegative = true;
             n *= -1;
        }
        while(n != 0){
            if(n % 2 == 1)
                ret *= x;
            x*= x;
            n /= 2;
        }
        if(isNegative){
            return 1 / ret;
        }
        return ret;

    }
};
