class Solution {
    
    public int memo(int i1,int j1,int i2,int[][] grid,int [][][] dp){
        
        int j2 = i1+j1-i2;
        if(i1 >= grid.length ||i2 >= grid.length || j1 >= grid[0].length || j2 >= grid[0].length) return (int)(Math.pow(-10,9));
        if(grid[i1][j1] == -1 || grid[i2][j2] == -1) return (int)(Math.pow(-10,9));
        
        if(i1 == grid.length-1 && j1 == grid[0].length-1) return grid[i1][j1];
        
        
        if(dp[i1][j1][i2] != -1) return dp[i1][j1][i2];
        
        int cherries = 0;
        if(i1 == i2 && j1 == j2)
            cherries += grid[i1][j1];
        else
            cherries += grid[i1][j1]+grid[i2][j2];
        
        
        int down =  memo(i1+1,j1,i2,grid,dp);
        int right = memo(i1,j1+1,i2,grid,dp);
        
        int up =  memo(i1+1,j1,i2+1,grid,dp);
        int left = memo(i1,j1+1,i2+1,grid,dp);
        
        cherries += Math.max(Math.max(down,right),Math.max(up,left));
        
        return dp[i1][j1][i2] = cherries;
        
    }
    
    
    public int cherryPickup(int[][] grid) {
        
        int dp[][][] = new int[grid.length][grid[0].length][grid.length];
        
        for(int i[][]:dp){
            for(int j[]:i)
                Arrays.fill(j,-1);
        }
        
        int ans = memo(0,0,0,grid,dp);
        return ans <0 ? 0:ans;
        
    }
}