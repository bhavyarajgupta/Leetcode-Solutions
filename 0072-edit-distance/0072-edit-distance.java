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
    
    public int minDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int[] prev=new int[m+1];
        int[] cur=new int[m+1];

        for(int j=0;j<=m;j++){
            prev[j] = j;
        }

        for(int i=1;i<n+1;i++){
            cur[0]=i;
            for(int j=1;j<m+1;j++){
                if(S1.charAt(i-1)==S2.charAt(j-1))
                    cur[j] = 0+prev[j-1];

                else cur[j] = 1+Math.min(prev[j-1],Math.min(prev[j],cur[j-1]));
            }
            prev = (int[])(cur.clone());
        }

        return prev[m];
    }
}