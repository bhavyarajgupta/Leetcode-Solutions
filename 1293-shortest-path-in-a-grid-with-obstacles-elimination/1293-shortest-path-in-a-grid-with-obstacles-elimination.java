class Solution {
    
    class Pair {
        int row;
        int col;
        int obs;
        int steps;
        
        Pair(int r, int c, int o, int s) {
            row = r;
            col = c;
            obs = o;
            steps = s;
        }
    }
    
    public int shortestPath(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0, 0, k, 0));
        boolean[][][] vis = new boolean[n][m][k + 1];
        vis[0][0][0] = true;
        
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()) {
            
            Pair front = q.remove();
            
            if(vis[front.row][front.col][front.obs] == true) continue;
            vis[front.row][front.col][front.obs] = true;
            
            if(front.row == n - 1 && front.col == m - 1)
                return front.steps;
            
            for(int[] d : dir) {
                int nr = front.row + d[0];
                int nc = front.col + d[1];
                
                if(nr < 0 || nc < 0 || nr == n || nc == m || (front.obs == 0 && grid[nr][nc] == 1))     
                    continue;
                
                if(grid[nr][nc] == 1)
                    q.add(new Pair(nr, nc, front.obs - 1, front.steps + 1));
                else
                    q.add(new Pair(nr, nc, front.obs, front.steps + 1));
            }
        }
        
        return -1;
    }
}