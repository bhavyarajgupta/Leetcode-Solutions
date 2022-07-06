class Solution {
    
   
    
     public int DFS(int r, int c, int[][] grid){
        //out of matrix , water cell , visited land
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c] == 0 || grid[r][c] == -1) return 0 ;
        
        grid[r][c] =-1;  //visited land
        
        //DFS on each side
        
         return (1+DFS(r+1,c,grid)+
        DFS(r-1,c,grid)+
        DFS(r,c+1,grid)+
        DFS(r,c-1,grid));
        
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        // int island = 0 ; //no of island;        
        //Loop matrix
        int area = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j] == 1){
                   int temp = DFS(i,j,grid);
                   area = Math.max(area,temp); 
                }
                
            }
        }
        
        return area;
    
    }
}