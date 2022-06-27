/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int t = sc.nextInt();
	    
	    while(t>0){
	        int n = sc.nextInt();
	        int k= sc.nextInt();
	        int arr[] = new int[n];
	        
	        for(int i=0;i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i=0;i<n;i++){
	            pq.add(arr[i]);
	            
	            if(i >= k){
	                System.out.print(pq.remove()+" ");
	            }
	        }
	        
	        while(pq.size()>0){
	            System.out.print(pq.remove()+" ");
	        }
	        
	        System.out.println();
	        
	        t--;
	    }
	}
}