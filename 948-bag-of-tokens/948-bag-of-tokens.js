/**
 * @param {number[]} tokens
 * @param {number} power
 * @return {number}
 */
var bagOfTokensScore = function(tokens, power) {
        tokens.sort(function(a, b){return a - b});
        let score = 0;
        let i=0;
        let j= tokens.length-1;
        while(i<=j){
            if((power - tokens[i]) >= 0){
                ++score;
                power -= tokens[i];
                ++i;
            }else{
                
                if(score>0 && i!=j){
                    --score;
                    power+=tokens[j];
                }
                
                --j;
            }
            
        }
        
        
        return score != 0?score:0;
};