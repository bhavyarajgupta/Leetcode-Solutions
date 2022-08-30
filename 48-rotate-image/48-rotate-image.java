class Solution {
//     //Brute Force
//     public void rotate(int[][] matrix) {
//         int mat[][] = new int[matrix.length][matrix.length];
        
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix.length;j++){
//                 mat[j][matrix.length-1-i] = matrix[i][j];
//             }
//         }
        
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix.length;j++){
//                 matrix[i][j] = mat[i][j];  
//             }
//         }
       
//     }
    
    
    public void transpose(int[][] m,int n){
      for(int i = 0; i < n; i++){
         for(int j = i; j < n;j++){
            int temp = m[i][j];
            m[i][j]= m[j][i];
            m[j][i] = temp;
         }
      }
        
        reverse(m,n);
    }
    
    public void reverse(int[][] m,int n){
        for(int i = 0; i < n; i++){
         for(int j = 0; j < n/2; j++){
            int temp = m[i][j];
            m[i][j]= m[i][n-1-j];
            m[i][n-1-j] = temp;
         }
      }
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        transpose(matrix,n);
        // reverse(matrix,n);
        
                
    }
    
    
}