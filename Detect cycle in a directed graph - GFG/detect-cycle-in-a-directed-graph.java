// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public static boolean DFS(int src , int []vis,ArrayList<ArrayList<Integer>> adj ){
        if(vis[src] == 0) return true;
        if(vis[src] == 1) return false;
        
        vis[src] = 0;
        
        for(Integer nbr:adj.get(src)){
            if(DFS(nbr,vis,adj) == true) return true;
        }
        
        vis[src] = 1;
        return false;
        
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        
        Arrays.fill(vis,-1);
        
        for(int i=0;i<V;i++){
            if(DFS(i,vis,adj)){
                return true;
            }
        }
        
        return false;
    }
}