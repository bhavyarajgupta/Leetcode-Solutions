// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> list = ob.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        ArrayList<Integer> max = new ArrayList<>();
        
        // for(int i=0;i<n;i++){
        //     maxheap.add(arr[i]);
        // }
        
        // for(int i=0;i<k;i++){
        //     max.add(maxheap.remove());
        // }
        
        for(int i=0;i<k;i++){
            minheap.add(arr[i]);
        }
        
        
        for(int i=k;i<n;i++){
            if(arr[i]>minheap.peek()){
                minheap.add(arr[i]);
                minheap.remove();
            }
        }
        
        for(int i=0;i<k;i++){
            max.add(minheap.remove());
        }
        
        Collections.reverse(max);
        
        
        return max;
    }
}