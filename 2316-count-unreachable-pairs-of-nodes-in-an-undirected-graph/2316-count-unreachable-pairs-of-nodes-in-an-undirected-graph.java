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
    
    
    public void DFS(int src,boolean[] vis, List<Integer> component){
        if(vis[src] == true) return;
        
        vis[src] = true;
        component.add(src);
        
        for(Integer nbr: adj[src]){
            DFS(nbr,vis,component);
        }
    }
    
}


class Solution {
    public long countPairs(int n, int[][] edges) {
        Graph graph = new Graph(n);
        
        for(int[] edge:edges){
            graph.addEdge(edge[0],edge[1]);
        }
        
        boolean vis[] = new boolean[n];
        
        long pairs =0;
        
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                
                List<Integer> comp = new ArrayList<>();
                graph.DFS(i,vis,comp);
                
                pairs = pairs + (comp.size()*((n*1l) - comp.size()));
            }
        }
        return pairs/2l;
    }
                 
}