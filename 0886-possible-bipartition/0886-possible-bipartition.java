class Solution {
    
    private boolean dfs(int src, int set, ArrayList<Integer>[]  graph, int vis[]) {
        
        if(vis[src] != -1) {
            if(vis[src] != set % 2) return false;
            return true;
        }
        
        vis[src] = set % 2;
        
        for(int nbr : graph[src])
            if(dfs(nbr, set + 1, graph, vis) == false)
                return false;
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[]  graph = new ArrayList[n+1];
        
        for(int i = 0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<dislikes.length;i++){
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }
        
        int vis[] = new int[n+1];
        Arrays.fill(vis,-1);
        for(int i = 0; i < graph.length; i++)
            if(vis[i] == -1 && dfs(i, 0, graph, vis) == false)
                return false;
        
        return true;
    }
}