class Solution {
    
    public int memorec(int i,int j,int obst[][],int dp[][]){
        
        if(i>=0 && j>=0 && obst[i][j] == 1) return 0;
        if(i == 0 && j==0) return 1;
        if(i <0 || j<0) return 0;
        
        if(dp[i][j] != -1 ) return dp[i][j];
        
        int up = memorec(i-1,j,obst,dp);
        int left = memorec(i,j-1,obst,dp);
        
        return dp[i][j] = up+left;
        
    }
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        
        return memorec(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,dp);
        
        
    }
}