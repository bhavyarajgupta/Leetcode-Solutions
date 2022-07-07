class Graph{
     public ArrayList<Integer> adj[];
    
    Graph(int n){  //constrctor
        adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();      // allocate empty arrayList   
        }
    }
    
    public void addEdge(int src , int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
    
    
    public void DFS(int src,boolean[] vis){
        if(vis[src] == true) return;
        
        vis[src] = true;
        
        
        for(Integer nbr: adj[src]){
            DFS(nbr,vis);
        }
    }
    
}

class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1) return -1;
        Graph graph = new Graph(n);
        
        for(int[] edge:connections){
            graph.addEdge(edge[0],edge[1]);
        }
        
        boolean vis[] = new boolean[n];
        
        int pairs =0;
        
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                
                graph.DFS(i,vis);
                
                // System.out.println(graph.adj.size());
                
                // pairs = pairs + (comp.size()*(n - comp.size()));
                pairs++;
            }
        }
        
        return pairs -1;
       

    }
}