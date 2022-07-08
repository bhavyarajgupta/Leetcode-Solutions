class Solution {
    int [][] dir = {{+1,0},{-1,0},{0,+1},{0,-1}};
    
    
    public void DFS(int r , int c , boolean [][] vis , int[][] heights ){
        if(vis[r][c] == true)  return;
        
        vis[r][c] = true;
        
        for(int i=0;i<4;i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr<0||nc<0||nr>=heights.length||nc>=heights[r].length){
                continue;
            }
            
            if(heights[nr][nc] >= heights[r][c]){
                DFS(nr,nc,vis,heights);
            }

        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n = heights.length , m = heights[0].length ;
        
        boolean [][] pacific = new boolean [n][m] ;
        for(int i=0;i<m;i++) DFS(0,i,pacific,heights);       //top wall
        for(int i=0;i<n;i++) DFS(i,0,pacific,heights);      //left wall
        
        boolean[][] atlantic = new boolean[n][m];
        for(int i=0;i<m;i++) DFS(n-1,i,atlantic,heights);       //bottom wall
        for(int i=0;i<n;i++) DFS(i,m-1,atlantic,heights);      //right wall
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    
                    res.add(point);
                }
            }
        }
        
        return res;
        
    }
}