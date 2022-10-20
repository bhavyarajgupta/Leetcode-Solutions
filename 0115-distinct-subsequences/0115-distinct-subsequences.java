class Solution {
    
    private int memo(int i,int j,String s, String t,int dp[][]){
        
        if(j==0) return 1;
        if(i==0) return 0;      // because i is already exhausted an there may be a possiblity from j
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ds = 0;
        if(s.charAt(i-1) == t.charAt(j-1)){
           ds = memo(i-1,j-1,s,t,dp) + memo(i-1,j,s,t,dp);
        }else{
            ds = memo(i-1,j,s,t,dp);
        }
        
        return dp[i][j] = ds;
        
    }
    
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int dp[][] = new int [n+1][m+1];
        
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        
        return memo(n,m,s,t,dp);
        
    }
}