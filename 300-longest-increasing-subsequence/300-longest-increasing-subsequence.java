class Solution {
    public int lengthOfLIS(int[] nums) {
        
        Integer[] dp= new Integer[nums.length];
        dp[0] = 1;
        int overallMax = 1;
        
        for(int i =1 ; i<dp.length;i++){
            Integer max = 0;
                
                for(int j = 0;j<i;j++){
                    if(nums[j] <nums[i]){
                        if(dp[j]> max){
                            max = dp[j];
                        }
                    }
                }
            dp[i] = max+1;
            
            if(dp[i] > overallMax){
                overallMax = dp[i];
            }
        }
        return overallMax;
    }
}