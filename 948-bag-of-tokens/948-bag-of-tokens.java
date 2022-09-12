class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int i=0;
        int j= tokens.length-1;
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
    }
}