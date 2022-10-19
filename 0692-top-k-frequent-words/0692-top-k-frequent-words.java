class Solution {
    
    class Pair implements Comparable<Pair>{
        String s;
        int freq;
        
        Pair(String s,int f){
            this.s = s;
            freq = f;
        }
        
        public int compareTo(Pair other){
            if(freq == other.freq)
                return this.s.compareTo(other.s);
            return other.freq-freq;
        }
    } 
    
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<String> ans = new ArrayList<>();
        
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(String s:map.keySet()){
            pq.add( new Pair(s,map.get(s)));
        }
        
        
        while(k-- > 0){
            String wrd = pq.remove().s;
            ans.add(wrd);
        }
        
        return ans;
    }
}