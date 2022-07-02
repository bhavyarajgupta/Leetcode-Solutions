class Solution {
       private void dfs(int[][] image, int sr, int sc, int color, int oldcolor) {
        
        if(sr < 0 || sc < 0 || sr > image.length - 1|| sc > image[0].length - 1 || image[sr][sc] == color)
            return;
        
        if(image[sr][sc] == oldcolor)
            image[sr][sc] = color;
        
        if(image[sr][sc] != color)
            return;
        
        dfs(image, sr + 1, sc, color, oldcolor);
        dfs(image, sr, sc + 1, color, oldcolor);
        dfs(image, sr - 1, sc, color, oldcolor);
        dfs(image, sr, sc - 1, color, oldcolor);
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}