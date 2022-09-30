private int memo(int i,int j1,int j2,int[][] grid,int[][][] dp){
if(j1 < 0 || j2 <0 || j1 >= grid[0].length || j2>=grid[0].length)
return (int)(Math.pow(-10,9));
if(i == grid.length-1){
if(j1 == j2) return grid[i][j1];
else return grid[i][j1]+grid[i][j2];
}
if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
int maxi = Integer.MIN_VALUE;
for(int dj1 = -1 ; dj1 <= 1;dj1++){
for(int dj2 = -1 ; dj2 <= 1;dj2++){
int ans = 0;
if(j1 == j2 )
ans = grid[i][j1]+memo(i+1,j1+dj1,j2+dj2,grid,dp);
else
ans = grid[i][j1]+grid[i][j2]+memo(i+1,j1+dj1,j2+dj2,grid,dp);
maxi = Math.max(maxi,ans);
}
}
return dp[i][j1][j2] = maxi;
}