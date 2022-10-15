class Solution {
    
    private int memorec(int idx ,int T,int[] coins,int dp[][]){
        if(idx == 0){
            return T%coins[0] == 0 ? 1:0;
        }
        
        if(dp[idx][T] != -1) return dp[idx][T];
        
        int ntake = memorec(idx-1,T,coins,dp);
        int take = 0;
        if(coins[idx] <= T)
            take = memorec(idx,T-coins[idx],coins,dp);
        
        return dp[idx][T] = take+ntake;
    }
    
    public int change(int amount, int[] coins) {
        int dp [][] = new int [coins.length][amount+1];
        
        for(int i[]:dp)
            Arrays.fill(i,-1);
        
       return memorec(coins.length-1,amount,coins,dp);
    }
}