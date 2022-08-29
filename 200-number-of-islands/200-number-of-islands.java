class Solution {
    
    void dfs(int i,int j,char[][] grid){
        if(i<0 || j<0 || i > grid.length-1 || j>grid[0].length-1 || grid[i][j] == '0' || grid[i][j] == 'X'){
            return ;
        }
        
        grid[i][j] = 'X';
        
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
    }
    
    public int numIslands(char[][] grid) {
        
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        
        return ans;
    }
}