class Solution {
  public int findJudge(int n, int[][] trust) {
    int table[][] = new int[n+1][2];
    
    for(int[] t : trust) {
      table[t[0]][0]++;
      table[t[1]][1]++;
    }
    
    for(int i = 1; i <= n; i++)
      if(table[i][0] == 0 && table[i][1] == n-1) return i;
    
    return -1;
  }
}