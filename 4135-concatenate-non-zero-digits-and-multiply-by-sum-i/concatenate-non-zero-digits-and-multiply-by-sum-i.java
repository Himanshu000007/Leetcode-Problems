class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;
        long len = 1;

        while(n != 0){
            
            int rem = n % 10;
            sum += rem;
            if(rem !=0){
                x = rem * len + x;
                len = len * 10;
            }
            n = n/10;
        }
        long ans = x * sum;
        return ans;
    }
}