class Solution {
        
    public int minFallingPathSum(int[][] matrix) {
       
        int dp[][] = new int [matrix.length][matrix[0].length];
        
        
        for(int j = 0;j<matrix[0].length;j++) dp[0][j] = matrix[0][j];
        
        
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int s = matrix[i][j] + dp[i-1][j];
                int sl = matrix[i][j] ;
                    if(j-1>=0) sl+=dp[i-1][j-1];
                    else sl += (int)Math.pow(10,9);;
                int sr = matrix[i][j] ;
                    if(j+1<matrix[0].length) sr+= dp[i-1][j+1];
                    else sr += (int)Math.pow(10,9);;
                 dp[i][j] = Math.min(s,Math.min(sl,sr));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++)
            min = Math.min(dp[matrix.length-1][j],min);
        
        
        
        return min;
    }
}