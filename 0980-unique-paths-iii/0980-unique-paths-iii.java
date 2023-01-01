class Solution {
    public int cnt;
    public int uniquePathsIII(int[][] grid) {
        
        cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        int starti = 0;
        int startj = 0;
        int endi = 0;
        int endj = 0;
        int empty = 0;

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(grid[i][j] == 1)
                {
                    starti = i;
                    startj = j;
                }
                else if(grid[i][j] == 2)
                {
                    endi = i;
                    endj = j;
                }
                else if(grid[i][j] == 0)
                {
                    empty++;
                }
            }
        }

        boolean vis[][] = new boolean[n][m];
        vis[starti][startj] = true;
        solve(starti , startj , endi , endj , empty , grid , vis);

        return cnt;

    }

    public int row[] = {-1 , 1 , 0 , 0};
    public int col[] = {0 , 0 , -1 , 1};
    public void solve(int sti ,int stj , int edi , int edj , int emp , int grid[][] , boolean vis[][])
    {
        
        if(sti == edi && stj == edj)
        {
            if(emp == -1)
                cnt++;
            
            return;    
        }
        for(int i = 0 ; i < 4 ; i++)
        {
            int nrow = sti + row[i];
            int ncol = stj + col[i];

            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length)
            {
                if(grid[nrow][ncol] != -1 && vis[nrow][ncol] == false)
                {
                    vis[nrow][ncol] = true;
                    solve(nrow , ncol , edi , edj , emp-1 , grid , vis);
                    vis[nrow][ncol] = false;
                }
            }
        }

        
    }
}