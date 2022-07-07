class Solution {
    
    private boolean helper(int i, String s1, int j, String s2, int k, String s3, Boolean[][] dp) {
        
        if(k == 0)
            return true;
        
        if(dp[i][j] != null)
            return dp[i][j];
        
        boolean one = false, two = false;
        
        if(i-1 >=0 && s3.charAt(k-1) == s1.charAt(i-1))
            one = helper(i - 1, s1, j, s2, k - 1, s3, dp);
        
        if(j-1 >= 0 && s3.charAt(k-1) == s2.charAt(j-1))
            two = helper(i, s1, j - 1, s2, k - 1, s3, dp);
        
        return dp[i][j] = one || two;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        
        if(n+m > len) return false;
        
        Boolean dp[][] = new Boolean[n+1][m+1];
        
        return helper(n, s1, m, s2, len, s3, dp);
    }
}