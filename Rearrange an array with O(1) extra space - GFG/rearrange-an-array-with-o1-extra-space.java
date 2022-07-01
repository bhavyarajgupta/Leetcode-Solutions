// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //testcases
        int t =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //size of array
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            long arr[] = new long[(int)n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[(int)i]  =Integer.parseInt(st[(int)i]);
                
           //calling arrange() function
           new Solution().arrange(arr, n);
           
           //printing the elements 
           for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
 
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long arr[], int n)
    {
        // int min = 0;
        // int max = n-1;
        // long maxel = arr[0]+1;
        // for(int i=1;i<n;i++){
        //     if(arr[i]+1>maxel){
        //         maxel=arr[i]+1;
        //     }
        // }
        
        // maxel = maxel+1;
        
        
        for(int i=0;i<n;i++){
            
            // if(i%2==0){
            arr[i]=(arr[(int)arr[i]]%n)*n + arr[i];
            // }else{
            // arr[i]=(arr[min++]%maxel)*maxel + arr[i];
            // }
        }
        
        for(int i=0;i<n;i++){
            arr[i] /= n;
        }
    }
}