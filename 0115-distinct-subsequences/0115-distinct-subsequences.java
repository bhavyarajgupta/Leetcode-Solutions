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
    
    int prime =(int)(Math.pow(10,9)+7);
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
         int[] prev=new int[m+1];
        prev[0]=1;
    
        for(int i=1;i<n+1;i++){
            for(int j=m;j>=1;j--){ // Reverse direction

                if(s.charAt(i-1)==t.charAt(j-1))
                    prev[j] = (prev[j-1] + prev[j])%prime;
                else
                    prev[j] = prev[j]; //can omit this statemwnt
            }
        }

        return prev[m];
        
    }
}