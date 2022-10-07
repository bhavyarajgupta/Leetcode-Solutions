class Solution {
    
    public boolean memo(int i,int [] nums,int targ,int dp[][]){
        
        if(targ == 0) return true;
        
        if(i == 0){
            if(nums[0] == targ){
                return true;
            }
            
            return false;
        }
        
        if(dp[i][targ] != -1) return dp[i][targ] == 0?false:true;
        
        boolean nottake = memo(i-1,nums,targ,dp);
        boolean take = false;
        
        if(nums[i] <= targ){
            take = memo(i-1,nums,targ-nums[i],dp);
        }
        
        dp[i][targ] = nottake||take?1:0;
        return nottake||take;
        
        
    }
    
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        
        if(sum % 2 != 0){
            return false;
        }else{
            int dp[][] = new int[nums.length][(sum/2)+1];
            
            for(int i[]:dp){
                Arrays.fill(i,-1);
            }
            
            return memo(nums.length-1,nums,sum/2,dp);
            
        }
        
        
        
        
        
    }
}