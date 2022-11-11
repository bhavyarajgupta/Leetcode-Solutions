class Solution {
    
    
    private boolean isPalindrome(int i,int j ,String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    private int memocuts(int i,String s,int dp[]){
        if(i == s.length()) return 0;
        
        if(dp[i] != -1) return dp[i];
          
        int mincost = Integer.MAX_VALUE;
        
        for(int j=i;j<s.length();j++){
                   
            
            if(isPalindrome(i,j,s) == true)
            {
                
                int cost = 1 + memocuts(j+1,s,dp);     
                mincost = Math.min(mincost,cost);
            }
            
            
        }
        
        return dp[i] = mincost;
        
    }
    
    public int minCut(String s) {
        int dp[] = new int[s.length()+1];
        
        dp[s.length()] = 0;
        
        for(int i = s.length()-1;i>=0;i--){
            
            int mincost = Integer.MAX_VALUE;
        
            for(int j=i;j<s.length();j++){

                if(isPalindrome(i,j,s) == true)
                {
                    int cost = 1 + memocuts(j+1,s,dp);     
                    mincost = Math.min(mincost,cost);
                }
            }
            dp[i] = mincost;
            
        }
        
        return dp[0]-1;
    }
}