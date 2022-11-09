class Solution 
{
    public int fun(int i,int j,int[] nums,int[][] dp)
    {
        if(i>j)  return 0;
        if(dp[i][j]!=-1)  return dp[i][j];
        int ans=Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++)
        {
            int cost=(nums[i-1]*nums[idx]*nums[j+1])+fun(i,idx-1,nums,dp)+fun(idx+1,j,nums,dp);
            ans=Math.max(ans,cost);
        }
        return dp[i][j]=ans;
    }
    
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //convert nums to points with added start and end
        int[] points = new int[n + 2];
        
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }

        int[][] dp = new int[n+2][n+2];
        
        //calculate from the tail.
        for(int i = n; i >= 0; i--) {
            for(int j = i+1; j < n+2; j++) {
                for(int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
         //1...n as the requried ballons that need to be burst
        return dp[0][n+1];   
    }
}