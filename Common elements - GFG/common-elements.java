// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        
        int len = n1>n2?n1>n3?n1:n3:n2>n3?n2:n3;
        // System.out.println(len);
        
        for(int i=0; i<len;i++){
            if(i<n1){
                map1.put(A[i],map1.getOrDefault(A[i],0)+1);
            }
            if(i<n2){
                map2.put(B[i],map2.getOrDefault(B[i],0)+1);
            }
            
        }
        
        for(int i=0;i<C.length;i++){
         
            
            if(map1.containsKey(C[i]) && map2.containsKey(C[i])){
                res.add(C[i]);
                map1.remove(C[i]);
                map2.remove(C[i]);
                
            }
            
            
            
        }
        
        return res;
        
    }
}