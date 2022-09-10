class Solution {
    public int maxProfit(int[] prices) {
    int ahead[]=new int[2];
    int cur[] =new int[2];
        
    int n = prices.length;
    ahead[0] = ahead[1] = 0;
        
    int profit = 0;
    
    for(int idx = n-1;idx >=0;idx--){
        for(int buy = 0; buy<=1; buy++){
            if(buy == 0){
                profit = Math.max(-prices[idx]+ahead[1],ahead[0]);
            }
            
            if(buy == 1)
            {
                profit = Math.max(prices[idx]+ahead[0],ahead[1]);
            }

                cur[buy]  = profit;
        } 
        
        ahead = (int[])(cur.clone());
    }
        
        return cur[0];
    }
}