class Solution {
    
    private int memo(int i,int j,String w1, String w2,int dp[][]){
        
        if(i == 0)
            return j;
        if(j == 0)
            return i;
    
        if(dp[i][j] != -1) return dp[i][j];
        
        
        if(w1.charAt(i-1) == w2.charAt(j-1)){
            return dp[i][j] = memo(i-1,j-1,w1,w2,dp);
        }
        else{
            
            int insert = memo(i,j-1,w1,w2,dp);
            int delete = memo(i-1,j,w1,w2,dp);
            int replace = memo(i-1,j-1,w1,w2,dp);
            
            return dp[i][j] = 1+ Math.min(insert,Math.min(delete,replace));
        }
        
    }
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int dp[][] = new int[n+1][m+1];
        
        for(int i[]:dp) Arrays.fill(i,-1);
        
        return memo(n,m,word1,word2,dp);
        
        
    }
}