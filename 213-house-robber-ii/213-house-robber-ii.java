class Solution {
    
    int tabFindMax(int [] nums,int n){
        int dp[] = new int[n];
        dp[0] = nums[0];
        
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if( i > 1) pick+=dp[i-2];
            int nonpic = 0+dp[i-1];
            dp[i] = Math.max(pick,nonpic);
        }
        
        return dp[n-1];        
    }
    
    public int rob(int[] nums) {
        
        if(nums.length == 1 ) return nums[0];
        
        int n = nums.length;
        
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];
        
        for(int i=0;i<n;i++){
            if(i !=0) arr1[i-1]  = nums[i];
            if(i != n-1) arr2[i]  = nums[i];
        }
        
        return Math.max(tabFindMax(arr1,n-1),tabFindMax(arr2,n-1));
    }
}