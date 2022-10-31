//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    
    private static int memo(int i,int prev,String S, int dp[][]){
        if( i == S.length()) return 0;
        
        if(dp[i][prev+1] != -1) return dp[i][prev+1]; 
        
        int ntake = 0+ memo(i+1,prev,S,dp);
        int take = 0;
        if(prev == -1 || S.charAt(i) > S.charAt(prev)){
            take = 1+memo(i+1,i,S,dp);
        }
        
        return dp[i][prev+1] = Math.max(take,ntake);
        
    }
    
    static int maxLength(String S){
        int dp[][] = new int[S.length()][S.length()];
        
        for(int i[]:dp) Arrays.fill(i,-1);
        
        
        return memo(0,-1,S,dp);
        
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}


// } Driver Code Ends