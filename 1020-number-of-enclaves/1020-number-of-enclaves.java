class Solution {
    
    int store = 0;
    boolean check = false;
    public int DFS(int r, int c, int[][] grid){
        //out of matrix , water cell , visited land
        
        if(r<0||c<0||r >=grid.length||c >=grid[0].length){
            check = true;
            return 0;
        }
        
        if(grid[r][c] == 0 || grid[r][c] == -1) 
        {
            return 0;
        }
        
        
        grid[r][c] =-1;  //visited land
        store++;
        //DFS on each side
        
        DFS(r+1,c,grid);
        DFS(r-1,c,grid);
        DFS(r,c+1,grid);
        DFS(r,c-1,grid);
        
        return store;
        
    }
    
    public int numEnclaves(int[][] grid) {
        
        int area = 0;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                   // if(i<1||j<1||i>=grid.length||j>=grid[0].length){
                   //      area = 0;
                   //   }else{/
                        
                        store = 0;
                        int temp = DFS(i,j,grid);
                        if(!check) area+=temp;   
                        check = false;
                   // 
                   
                }
                
            }
        }
        
        return area;

    }
}