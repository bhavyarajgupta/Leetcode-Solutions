//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    private static boolean isPossible(int[] stalls,int k,int dist){
        
        int count = 1,place = stalls[0];
    
        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - place >= dist){
                count++;
                place = stalls[i];
            }    
            if(count == k){
                return true;
            }
        }
        
        return false;
    }
    
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int lo = 1;
        int high = stalls[stalls.length-1]-stalls[0];
        int ans = -1;
        
        while(lo<=high){
            int mid = lo + (high-lo)/2;
            
            if(isPossible(stalls,k,mid)){
                
                ans = mid;
                
                lo = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        
        return ans;
    }
}