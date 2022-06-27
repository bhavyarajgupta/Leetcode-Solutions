class Solution {
    
    static class Pair implements Comparable<Pair> {
        char ch;
        int freq;
        
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Pair x) {
            if(freq == x.freq)
                return ch - x.ch;
            return x.freq - freq;
        }
        
    }
    
    public String reorganizeString(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(Character key : map.keySet())
            pq.add(new Pair(key, map.get(key)));
        
        StringBuilder sb = new StringBuilder("");
        
        while(pq.size() > 0) {
            
            Pair odd = pq.remove();
            sb.append(odd.ch);
            odd.freq--;
            
            if(pq.size() == 0 && odd.freq > 0)
                return "";
            
            if(pq.size() > 0) {
                
                Pair even = pq.remove();
                sb.append(even.ch);
                even.freq--;
                
                if(even.freq > 0)
                    pq.add(even);
                
            }
            
            if(odd.freq > 0)
                pq.add(odd);
            
        }
        
        return sb.toString();
    }
}