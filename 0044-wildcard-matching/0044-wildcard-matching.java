class Solution {
    
    public boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=1; i<=m; i++) {
            dp[i][0] = false;
        }

        for(int j=1; j<=n; j++) {
            if(p.charAt(j-1)=='*'){
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (p.charAt(j-1)!='*') {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
       
    }
    
    private boolean is_match(int m,int n,String p,String s,Boolean dp[][]){
        
        //Base Case
        //if m and n both are 0 i.e strings are matching
        if (m<0 && n<0) return true;
        
        // if n has some character but m is empty
        if (m<0 && n>=0) return false;
        
        // if m has some character but n is empty
        
        if (n<0 && m>=0) {
            for (int i=0;i<=m;i++){
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }
        
        //Memorisation
        if (dp[m][n] != null) return dp[m][n];
        
        //if both the character is equal || patern[m] == ?
        if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '?'){
            return dp[m][n] = is_match(m-1,n-1,p,s,dp);
        }
        
        // if p has '*'
        if (p.charAt(m) == '*'){
            return dp[m][n] = is_match(m-1,n,p,s,dp) || is_match(m,n-1,p,s,dp);
        }
        // if both the character is not equal
        return false;
            
    }
}