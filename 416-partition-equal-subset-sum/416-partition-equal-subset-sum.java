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
        }
            boolean dp[][] = new boolean[nums.length][(sum/2)+1];
            
            int targ = sum/2;
            
            
            for(int i=0;i<nums.length;i++)
                dp[i][0] = true;
            
            if(nums[0]<=targ)
             dp[0][nums[0]] = true;
        
            for(int i=1;i<nums.length;i++){
                for(int j=1;j<=targ;j++){
                    
                    boolean nottake = dp[i-1][j];
                    boolean take = false;

                    if(nums[i] <= j){
                        take = dp[i-1][j-nums[i]];
                    }

                    dp[i][j] = nottake||take ;
                               
                }
            
            
        }
        
        
        return dp[nums.length-1][sum/2];
        
    }
}