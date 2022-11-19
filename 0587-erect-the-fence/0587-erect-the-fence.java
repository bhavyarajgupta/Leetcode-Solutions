class Solution {
    
    public int[][] outerTrees(int[][] trees) {
        if(trees.length == 3){
            return trees;
        }
        Stack<int[]> upper = new Stack<>();
        Stack<int[]> lower = new Stack<>();
        
        Arrays.sort(trees,(p,q) ->
                  q[0]-p[0]==0?q[1]-p[1]:q[0]-p[0]);
        
        for(int i = 0 ; i < trees.length ; i++){
            int size = trees.length;
            while(upper.size() >= 2 && angle(upper.get(upper.size() - 2),upper.get(upper.size() - 1),trees[i]) > 0){
                upper.pop();  
                }
            while(lower.size() >= 2 && angle(lower.get(lower.size() - 2),lower.get(lower.size() - 1),trees[i]) < 0){
                 lower.pop();  
              }
            upper.push(trees[i]);
            lower.push(trees[i]);
        }
        
        
        Set<int[]> res= new HashSet<>(lower);
        res.addAll(upper);
        return res.toArray(new int[res.size()][]);
    }
    
    public int angle(int[] A , int[] B , int[] C){
        return (C[0] - A[0]) * (B[1] - A[1]) - (B[0] - A[0]) * (C[1] - A[1]);
    }
}