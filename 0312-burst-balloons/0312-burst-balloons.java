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
    public int maxCoins(int[] nums) 
    {
        int[] ref=new int[nums.length+2];
        ref[0]=1;
        ref[ref.length-1]=1;
        for(int i=0;i<nums.length;i++)
        {
            ref[i+1]=nums[i];
        }
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int[] i : dp)  Arrays.fill(i,-1);
        return fun(1,nums.length,ref,dp);
    }
}