class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        for(int i=0;i<matrix.length;i++){
            int j=0;
            int k=matrix[i].length-1;
           
            while(k-j > 1){
                int mid = (j+k)/2;
                if(matrix[i][mid] < target){
                    j = mid+1;
                }else{
                    k = mid;
                }
            }
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][k] == target) {
                return true;
            }
            
        }
        
        return false;
    }
}