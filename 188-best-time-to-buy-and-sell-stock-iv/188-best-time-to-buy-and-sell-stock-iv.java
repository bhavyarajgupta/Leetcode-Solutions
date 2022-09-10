class Solution {
    int fnc(int day,int buy,int cap, int [] pr,int dp[][][]){
        if(day == pr.length || cap == 0) return 0;
        
        if(dp[day][buy][cap] != -1) return dp[day][buy][cap] ;
        
        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(-pr[day]+fnc(day+1,0,cap,pr,dp),0+fnc(day+1,1,cap,pr,dp));
        }else{
            profit = Math.max(pr[day]+fnc(day+1,1,cap-1,pr,dp),0+fnc(day+1,0,cap,pr,dp));
        }
        
        return dp[day][buy][cap] = profit;
    }
    
    public int maxProfit(int k, int[] A) {
        int dp[][][] = new int[A.length][2][k+1];
        for (int[][] row : dp) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }
        
        
        return fnc(0,1,k,A,dp);
    }
}