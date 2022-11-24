class Solution {
    
    public boolean dfs(char[][] board,int i,int j,int no,String word){
        if(no == word.length()){
            return true;
            
        }
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0'){
            return false;
        }
        
        if(board[i][j] != word.charAt(no)){
            return false;
        }
        
        
        char temp = board[i][j];
        board[i][j] = '0';
        
        boolean ans = 
        dfs(board,i+1,j,no+1,word)||
        dfs(board,i,j+1,no+1,word)||
        dfs(board,i-1,j,no+1,word)||
        dfs(board,i,j-1,no+1,word);

        board[i][j] = temp;
        return ans;
    }
    
    public boolean exist(char[][] board, String word) {
        
        
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(board,i,j,0,word))
                    return true;
            }
        }
        
        return false;
    }
}