class Solution {
    
     
//     private int memo(int i,int j,List<List<Integer>> triangle,int [][]dp){
        
//         if(i == triangle.size()-1) return triangle.get(triangle.size()-1).get(j);
        
//         if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        
//         int d = triangle.get(i).get(j) + memo(i+1,j,triangle,dp);
//         int dg = triangle.get(i).get(j) + memo(i+1,j+1,triangle,dp);
        
//         return dp[i][j] = Math.min(d,dg);
//     }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp [][] = new int[triangle.size()][triangle.size()];
        
        for(int j = 0; j<triangle.size();j++){
            dp[triangle.size()-1][j] = triangle.get(triangle.size()-1).get(j); 
        }
        
        for(int i = triangle.size()-2;i>=0;i--){
            for(int j = i;j>=0;j--){
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];
        
                dp[i][j] = Math.min(d,dg);
            }
        }
        
        return dp[0][0];
    }
}