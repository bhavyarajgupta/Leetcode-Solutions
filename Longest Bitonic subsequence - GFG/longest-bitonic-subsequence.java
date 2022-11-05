//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int dp1[] = new int[nums.length];
        Arrays.fill(dp1,1);
        
        //Increasing Subsequence
        for(int i =0 ;i<nums.length;i++){
            for(int prev = 0; prev < i;prev++){
                if( nums[prev] < nums[i]  && 1+dp1[prev] > dp1[i]  ){
                    dp1[i] = 1+dp1[prev];
                }
            }
            
        }
        
        int dp2[] = new int[nums.length];
        Arrays.fill(dp2,1);
        
        //Decreasing Subsequence
        for(int i =nums.length-1; i>=0;i--){
            for(int prev = nums.length-1; prev > i;prev--){
                if( nums[prev] < nums[i]  && 1+dp2[prev] > dp2[i]  ){
                    dp2[i] = 1+dp2[prev];
                }
            }
            
        }
        
        
        //Bitonic subsequence increasing + decreasing - 1
        int maxi = 0;
        for(int i=0;i<nums.length;i++){
            maxi = Math.max(maxi,dp1[i]+dp2[i]-1);
        }
        
        return maxi;
    }
}