//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    private int memorec(int idx,int T,int[] cuts,int dp[][]){
        if(idx == 0){
            return T*cuts[0];
        }
        
        if(dp[idx][T] != -1) return dp[idx][T];
        
        int ntake = memorec(idx-1,T,cuts,dp);
        int take = Integer.MIN_VALUE;
        int rodlen = idx+1;
        if(rodlen<=T) take = cuts[idx]+memorec(idx,T-rodlen,cuts,dp);
        
        return dp[idx][T] = Math.max(take,ntake);
        
    }
    
    public int cutRod(int price[], int n) {
       int dp[][] = new int [n][n+1];
        
        // for(int i[]:dp)
        //     Arrays.fill(i,-1);
        
        // return memorec(n-1,n,price,dp);
        
        for(int i =0;i<=n;i++){
            dp[0][i] = i*price[0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++)
            {
                int ntake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                int rodlen = i+1;
                if(rodlen<=j) take = price[i]+dp[i][j-rodlen];
                
                dp[i][j] = Math.max(take,ntake); 
            }
        }
        
        return dp[n-1][n];
    }
}