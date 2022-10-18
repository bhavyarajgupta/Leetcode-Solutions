//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int LCS(String s1,String s2){
        int dp[][] = new int [s1.length()+1][s2.length()+1];
        
        for(int i[]:dp){
            Arrays.fill(i,0);
        }
        
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                
                int lcs = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    lcs = 1+dp[i-1][j-1];
                }else{
                    lcs = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
                dp[i][j] = lcs;
            }
        }
        
        
        return dp[s1.length()][s2.length()];
        
    }
    
	public int minOperations(String str1, String str2) 
	{ 
	    return str1.length() + str2.length() - 2*(LCS(str1,str2));
	} 
}