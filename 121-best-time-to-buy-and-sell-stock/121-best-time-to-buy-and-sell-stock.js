/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let mini = prices[0];
    let profit = 0;
    
    for(let i =1;i<prices.length;i++){
        const cost = prices[i] - mini;
        profit = Math.max(cost,profit);
        mini = Math.min(mini,prices[i]);
    }
    
    return profit;
};