class Solution {
    
    private int maximumScore(int idx, int first, int[] nums, int[] multipliers, Integer[][]dp) {
        if(idx == multipliers.length) return 0;
        if(dp[first][idx] != null) return dp[first][idx];
        
        int last = nums.length - 1 - (idx - first);
        
        int left = nums[first] * multipliers[idx] + maximumScore(idx+1, first+1, nums, multipliers, dp);
        int right = nums[last] * multipliers[idx] + maximumScore(idx+1, first, nums, multipliers, dp);
        
        return dp[first][idx] = Math.max(left, right);
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] dp = new Integer[multipliers.length + 1][multipliers.length + 1];
        return maximumScore(0, 0, nums, multipliers, dp);
    }
}