// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int x:a){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        for(int x:map.keySet()){
            if(map.get(x) > size/2){
                return x;
            }
        }
        return -1;
    }
}