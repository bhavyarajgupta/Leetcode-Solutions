class Solution {
    
    
    private int FindMax(int i ,int [] nums,int dp[]){
               
        if(i == 0) return nums[i];
        if(i < 0) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int take = nums[i] + FindMax(i-2,nums,dp);
        int ntake = 0 + FindMax(i-1,nums,dp);
        
        return dp[i] = Math.max(take,ntake);
    }
    
    public int rob(int[] nums) {
        int dp[]= new int[nums.length];
        
        Arrays.fill(dp,-1);
        
        
        return FindMax(nums.length-1,nums,dp);
        
    }
}