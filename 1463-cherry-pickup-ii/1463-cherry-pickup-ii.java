class Solution {
       
    public int cherryPickup(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        
        for(int j1 = 0; j1<m;j1++){
            for(int j2 = 0; j2<m;j2++){
                
                if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1]+grid[n-1][j2];
            }
        }
        
        
        for(int i = grid.length-2;i>=0;i--){
            for(int j1 = 0;j1<m;j1++){
                for(int j2 = 0;j2<m;j2++){
                    
                    int maxi = Integer.MIN_VALUE;

                    //Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                      for (int dj = -1; dj <= 1; dj++) {

                        int ans;

                        if (j1 == j2)
                          ans = grid[i][j1];
                        else
                          ans = grid[i][j1] + grid[i][j2];

                        if ((j1 + di < 0 || j1 + di >= m) ||
                          (j2 + dj < 0 || j2 + dj >= m))

                          ans += -1e9;
                        else
                          ans += dp[i + 1][j1 + di][j2 + dj];

                        maxi = Math.max(ans, maxi);
                      }
                    }
                    
                    dp[i][j1][j2] = maxi;
                }                
            }
        }
                
        return dp[0][0][grid[0].length-1];
    }
}