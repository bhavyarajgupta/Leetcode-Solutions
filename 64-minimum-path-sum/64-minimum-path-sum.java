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
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        
        return recMemo(grid.length-1,grid[0].length-1,grid,dp);
    }
}