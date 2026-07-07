class Solution {
    public long sumAndMultiply(int n) {
        long sum  =0;
        long num = 0;
        long d = 1;
        while(n > 0){
            int digit = n%10;
            if(digit != 0){
                num += digit * d;
                sum += digit;
                d *= 10;
            }
            n /= 10;
        }
        return num * sum;
        
    }
}