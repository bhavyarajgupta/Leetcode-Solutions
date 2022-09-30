class Solution {
        
    public int minFallingPathSum(int[][] matrix) {
       
        int prev[] = new int [matrix.length];
        
        for(int j = 0;j<matrix[0].length;j++) prev[j] = matrix[0][j];
        
        for(int i=1;i<matrix.length;i++){
            
            int curr[] = new int [matrix[0].length];
            
            for(int j=0;j<matrix[0].length;j++){
                int s = matrix[i][j] + prev[j];
                int sl = matrix[i][j] ;
                    if(j-1>=0) sl+=prev[j-1];
                    else sl += (int)Math.pow(10,9);;
                int sr = matrix[i][j] ;
                    if(j+1<matrix[0].length) sr+= prev[j+1];
                    else sr += (int)Math.pow(10,9);;
                 curr[j] = Math.min(s,Math.min(sl,sr));
            }
            
            prev = curr;
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++)
            min = Math.min(prev[j],min);
        
        
        
        return min;
    }
}