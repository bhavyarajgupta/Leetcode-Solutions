class Solution {
    
    public int recMemo(int i,int j,int[][] grid,int[][] dp)
    {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int)Math.pow(10,9);// such that the sum to that path becomes soo big that it gets excluded
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = grid[i][j] + recMemo(i-1,j,grid,dp);
        int left = grid[i][j] + recMemo(i,j-1,grid,dp);
        
        return dp[i][j] = Math.min(left,up);
    }  
    
    
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else{
                    int up = grid[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);

                    int left = grid[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left += (int)Math.pow(10,9);

                    dp[i][j] = Math.min(up,left);
                }  
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }
}