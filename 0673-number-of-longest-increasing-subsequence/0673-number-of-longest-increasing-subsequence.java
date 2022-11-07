class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        
        int maxi = 1;
        for(int i=0 ; i < nums.length;i++){
            for(int j=0;j<i;j++){
              if(nums[j]<nums[i] && dp[j]+1 > dp[i]){
                  dp[i] = 1+dp[i];
                  //increase 
                  count[i] = count[j];
              }else if(nums[j]<nums[i] && dp[j]+1 == dp[i]){
                  
                  //increment the count
                  count[i] += count[j];
              }  
                
            }
                maxi = Math.max(maxi,dp[i]);
        }
        
        int total = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i] == maxi){
                total += count[i];
            }
        }
        
        return total;
    }
}