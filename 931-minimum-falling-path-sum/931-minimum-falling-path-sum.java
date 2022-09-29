class Solution {
    
    public int memo(int i,int j,int[][] m,int [][]dp){
        
        if(j<0 || j >= m[0].length) return (int)Math.pow(10,9);
        if(i == 0) return m[0][j];
        
        if(dp[i][j] != 211) return dp[i][j];
        
        int s = m[i][j] + memo(i-1,j,m,dp);
        int sl = m[i][j] + memo(i-1,j-1,m,dp);
        int sr = m[i][j] + memo(i-1,j+1,m,dp);
        
        return dp[i][j] = Math.min(s,Math.min(sl,sr));
    }
    
    public int minFallingPathSum(int[][] matrix) {
       
        
        int dp[][] = new int [matrix.length][matrix[0].length];
        
        for(int k[]:dp){
            Arrays.fill(k,211);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int j=0;j<matrix[0].length;j++)
            min = Math.min(memo(matrix.length-1,j,matrix,dp),min);
        
        
        return min;
    }
}