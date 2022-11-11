class Solution {
    
    private int memo(int i,int n, int[] arr,int k,int dp[])
    {
        if( i == n) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int maxilocal = Integer.MIN_VALUE, Max = Integer.MIN_VALUE;
        int len = 0;
            
        for(int j = i;j< Math.min(n,i+k);j++){
            len++;
            maxilocal = Math.max(maxilocal,arr[j]);
            
            int sum = len * maxilocal + memo(j+1,n,arr,k,dp);
            Max = Math.max(Max,sum);
        }    
        
        return dp[i] = Max;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int dp[] = new int[arr.length+1];
        
        // Arrays.fill(dp,0);
        dp[arr.length] = 0;
        
        for(int i=arr.length-1;i>=0;i--){
            int maxilocal = Integer.MIN_VALUE, Max = Integer.MIN_VALUE;
            int len = 0;

            for(int j = i;j<Math.min(arr.length,i+k);j++){
                len++;
                maxilocal = Math.max(maxilocal,arr[j]);

                int sum = len * maxilocal + dp[j+1];
                Max = Math.max(Max,sum);
            }    

            dp[i] = Max;
        }
        
        
        // return memo(0,arr.length,arr,k,dp);
        return dp[0];
        
    }
}