class Solution {
    public int fibMem(int n, int [] dp){
        //Base Case
        if(n == 0 || n==1){
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int fib1 = fibMem(n-1,dp);
        int fib2 = fibMem(n-2,dp);
        
        int fibsum = fib1+fib2;
        
        dp[n] = fibsum;
        
        return dp[n];
        
        
    }
    public int fib(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int  res = fibMem(n,dp);
        
        
        return res;
    }
}