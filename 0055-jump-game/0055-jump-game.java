class Solution {
    
    public boolean jmp(int ind,int[] nums,int dp[]){
        if(ind == nums.length-1) return true;
        
        if(dp[ind] != -1) return dp[ind] == 1? true: false;
        
        int jump = nums[ind];
        boolean check = false;
        for(int i = ind+1; i <= Math.min(nums.length-1, ind+jump); i++)
            check = check || jmp(i, nums,dp);
        
        dp[ind] = check == true?1:0;
        return check;
    }
    
    public boolean canJump(int[] nums) {
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return jmp(0,nums,dp);
    }
}