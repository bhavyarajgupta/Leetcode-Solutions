class Solution {
    
    private boolean dfs(int source , int dest ,ArrayList<Integer>[] adjList ,boolean []vis){
        if(vis[source]) return false;
        if(source  == dest) return true;
        
        vis[source] = true;
        
        for(Integer nbr:adjList[source]){
            if(dfs(nbr,dest,adjList,vis)){
                return true;
            }
            
        }
        return false;
    }
        
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[]  adjList = new ArrayList[n];
        
        for(int i = 0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        boolean vis[] = new boolean[n];
        
        return dfs(source , destination , adjList , vis);
    }
}