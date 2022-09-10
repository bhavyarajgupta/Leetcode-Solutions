/**
 * @param {number[]} prices
 * @return {number}
 */

function f(idx,buy,prices,dp){
    if(idx == prices.length) return 0;
    
    if(dp[buy][idx] !=-1) return dp[buy][idx];
    
    let profit = 0;
    if(buy == 1){
        profit = Math.max(-prices[idx]+f(idx+1,0,prices,dp),f(idx+1,1,prices,dp));
    }else{
        profit = Math.max(prices[idx]+f(idx+1,1,prices,dp),f(idx+1,0,prices,dp));
    }
    
    return dp[buy][idx] = profit;
}

var maxProfit = function(prices) {
    const dp = new Array(2).fill(0).map(p => new Array(prices.length).fill(-1));
    // console.log(dp);
    
    return f(0,1,prices,dp);
    
};