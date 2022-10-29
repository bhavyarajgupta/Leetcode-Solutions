class Solution {
    
    private int memo(int idx,int buy,int[] prices,int dp[][]){
        
        if(idx >= prices.length) return 0;
       
        
        if(dp[idx][buy] != -1) return dp[idx][buy]; 
        
        
        int max = 0;
        if(buy == 1){
            max = Math.max((-prices[idx]+memo(idx+1,0,prices,dp)),memo(idx+1,1,prices,dp));
        }else{
            max = Math.max((prices[idx]+memo(idx+2,1,prices,dp)),memo(idx+1,0,prices,dp));
        }
        
        return dp[idx][buy] = max;
    }
    
    
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[prices.length][2];
        
        for(int i[]:dp)
            Arrays.fill(i,-1);
        
        
        return memo(0,1,prices,dp);
                
    }
}