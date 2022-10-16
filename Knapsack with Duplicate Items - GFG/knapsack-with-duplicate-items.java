//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int recmemo(int idx,int T,int val[], int wt[],int [][]dp){
        
        if(idx == 0){
            return ((int)(T/wt[0]))*val[0];
        }
        
        if(dp[idx][T] != -1) return dp[idx][T];
        
        int ntake = recmemo(idx-1,T,val,wt,dp);
        int take = 0;
        if(wt[idx] <= T) take = val[idx]+recmemo(idx,T-wt[idx],val,wt,dp);
        
        return dp[idx][T] = Math.max( ntake ,take); 
    }
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][]= new int[N][W+1];
        
        for(int i=0;i<= W;i++){
            dp[0][i] = ((int)(i/wt[0]))*val[0];
        }
        
        for(int i=1;i<N;i++){
            for(int j = 0;j<= W;j++){
                int ntake = dp[i-1][j];
                int take = 0;
                if(wt[i] <= j) take = val[i]+dp[i][j-wt[i]];
        
                dp[i][j] = Math.max( ntake ,take); 
            }
        }
        
        return dp[N-1][W];
    }
}