class Solution {
    private int memo(int idx,int buy,int[] prices,int dp[][],int fee){
        
        if(idx >= prices.length) return 0;
       
        
        if(dp[idx][buy] != -1) return dp[idx][buy]; 
        
        
        int max = 0;
        if(buy == 1){
            max = Math.max((-prices[idx]-fee+memo(idx+1,0,prices,dp,fee)),memo(idx+1,1,prices,dp,fee));
        }else{
            max = Math.max((prices[idx]+memo(idx+1,1,prices,dp,fee)),memo(idx+1,0,prices,dp,fee));
        }
        
        return dp[idx][buy] = max;
    }
    public int maxProfit(int[] prices, int fee) {
        
        int dp[][] = new int[prices.length+2][2];
        
        
        //Base case put everything as 0
        for(int i[]:dp)
            Arrays.fill(i,0);
        
        for(int idx = prices.length-1;idx>=0;idx--){
               
            dp[idx][1] = Math.max((-prices[idx]+dp[idx+1][0]),dp[idx+1][1]);

            dp[idx][0] = Math.max((prices[idx]-fee+dp[idx+1][1]),dp[idx+1][0]);
                
        }
        
        return dp[0][1];
        
    }
}