class Solution {
    
    private int memo(int i,int j,String text1, String text2,int dp[][]){
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int lcs = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            lcs = 1+memo(i-1,j-1,text1,text2,dp);
        }else{
        
            lcs = Math.max(memo(i,j-1,text1,text2,dp),memo(i-1,j,text1,text2,dp));
            
        }
        
        return dp[i][j] = lcs;
        
    }
    
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        
        return memo(text1.length()-1,text2.length()-1,text1,text2,dp);
        // return lcsDP(text1,text2,text1.length(),text2.length(),dp);
    }
}