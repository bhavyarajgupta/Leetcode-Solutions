class Solution {
    
    static class Pair implements Comparable<Pair> {
        String s;
        int freq;
        
        Pair(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Pair x) {
            if(freq == x.freq) return s.compareTo(x.s);
                // return s - x.s;
            return x.freq - freq;
        }
        
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++) {
            String ss = words[i];
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        
        }
     
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(String key : map.keySet())
            pq.add(new Pair(key, map.get(key)));
        
        int j = 0;
        while(j<k){
            res.add(pq.remove().s);
            j++;
        }
     

        
        return res;
        
    }
}