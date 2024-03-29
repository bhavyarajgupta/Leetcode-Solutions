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
        
        // for(int i[]:dp){
        //     Arrays.fill(i,-1);
        // }
        
//         return memo(text1.length()-1,text2.length()-1,text1,text2,dp);
        
        for(int i=0;i<=text1.length()-1;i++){
            dp[i][0] = 0;
        }
        
        for(int j=0;j<=text2.length()-1;j++){
            dp[0][j] = 0;
        }
        
        
        
       for(int i=1;i<=text1.length();i++){
        for(int j=1;j<=text2.length();j++){
            
            int lcs = 0;
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                lcs = 1+dp[i-1][j-1];
            }else{

                lcs = Math.max(dp[i][j-1],dp[i-1][j]);

            }

            dp[i][j] = lcs;
            
        }
           
       } 
        
        return dp[text1.length()][text2.length()];
       
    }
}