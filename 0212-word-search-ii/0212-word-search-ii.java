class Solution {
    
    //Trie Usage for storing  the entire words character by character with ending by the word it self 
    
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private void dfs(int r, int c, char board[][], TrieNode root, ArrayList<String> ans) {
        
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == '0') 
            return ;
        
        char ch = board[r][c];
        if(root.children[ch - 'a'] == null) return;
        
        root = root.children[ch - 'a'];
        if(root.word != null) {
            ans.add(root.word);
            root.word = null; //de-duplicate
        }
        
        board[r][c] = '0';
        dfs(r + 1, c, board, root, ans);
        dfs(r - 1, c, board, root, ans);
        dfs(r, c + 1, board, root, ans);
        dfs(r, c - 1, board, root, ans);
        board[r][c] = ch;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if(p.children[ch] == null) p.children[ch] = new TrieNode();
                p = p.children[ch];
            }
            p.word = word;
        }
        
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> ans = new ArrayList();
        TrieNode root = buildTrie(words);
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                dfs(i, j, board, root, ans);
        
        return ans;
    }
}