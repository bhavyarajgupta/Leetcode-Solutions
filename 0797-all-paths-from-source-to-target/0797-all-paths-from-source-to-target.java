class Solution {

    
    public void DFS(int src, int desc,boolean [] vis,int[][] graph,List<Integer>              path,List<List<Integer>> paths){
        
        if(vis[src] == true) return;
        
        vis[src] = true;
        path.add(src);
        
        if(src == desc){
            paths.add(new ArrayList<>(path));       //DEEP COPY
        }
        
        for(int nbr:graph[src]){
            DFS(nbr,desc,vis,graph,path,paths);
        }
        
        vis[src] = false;
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        
        boolean [] vis = new boolean[graph.length];
        
        DFS(0,graph.length-1,vis,graph,path,paths);
        
        return paths;
    }
}