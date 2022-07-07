class Solution {
    
    void dfs(int sr, int sc, char[][] board, boolean boundry) {
        
        if(sr < 0 || sc < 0 || sr == board.length || sc == board[0].length || board[sr][sc] == 'X' ||  board[sr][sc] == 'N')
            return;
        
        if(!boundry)
            board[sr][sc] = 'X';
        else
            board[sr][sc] = 'N';
        
        dfs(sr + 1, sc, board, boundry);
        dfs(sr - 1, sc, board, boundry);
        dfs(sr, sc + 1, board, boundry);
        dfs(sr, sc - 1, board, boundry);
    }
    
    public void solve(char[][] board) {
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == 'O') {
                    if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)
                        dfs(i, j, board, true);
                }
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == 'O') {
                    dfs(i, j, board, false);
                }
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == 'N')
                    board[i][j] = 'O';
    }
}