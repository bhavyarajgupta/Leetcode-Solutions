class Solution {
    class Graph{
        public ArrayList<Integer>[] adj;
        
        Graph(int n){
            adj = new ArrayList[n];
            
            for(int i=0;i<n;i++){
                adj[i] = new ArrayList<>();
            }
        }
        
        public void addEdge (int src,int des){
            adj[src].add(des);
            adj[des].add(src);
        }
    }
    
    public  boolean DFS(int src,int desc,Graph g,boolean[] vis){
        if(src == desc) return true;
        if(vis[src] == true) return false;
        vis[src] = true;
        
        for(int nbr:g.adj[src]){
            if(DFS(nbr,desc,g,vis) == true){
                return true;
            }
        }
        
        return false;
    }
    
    
    public boolean BFS(int src , int dest,Graph g){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[g.adj.length];
        q.add(src);
        
        while(q.size() > 0){
            int front = q.remove();
            if(vis[front] == true) continue;
            if(front == dest) return true;
            vis[front] = true;
            
            for(Integer nbr: g.adj[front]){
                if(vis[nbr] == false){
                    q.add(nbr);   
                }
            }
        }
        
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        
        for(int i=0;i<edges.length;i++){
            g.addEdge(edges[i][0],edges[i][1]);
        }
        
        boolean []vis = new boolean[n];
        
        // return DFS(source,destination,g,vis);
        return BFS(source , destination,g);
        
    }
}