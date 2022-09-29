class Solution {
    
    class Pair implements Comparable<Pair>{
        int val;
        int diff;
        
        Pair(int val,int diff){
            this.val = val;
            this.diff = diff;
        }
        
        public int compareTo(Pair other){
            if(diff == other.diff) return val - other.val;
            return diff - other.diff;
        }
    }
                                           
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i:arr){
            Pair temp = new Pair(i,Math.abs(x-i));
            pq.add(temp);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty() && k-->0){
            ans.add(pq.remove().val);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}