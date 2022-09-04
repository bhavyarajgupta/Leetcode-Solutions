class Solution {
    
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        
        Pair(int n,int f){
            num = n;
            freq = f;
        }
        
        public int compareTo(Pair other){
            return freq-other.freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Integer num:map.keySet()){
            
            if(pq.size() == k){
                if(pq.peek().freq < map.get(num)){
                    pq.remove();
                    pq.add(new Pair(num,map.get(num)));
                }
            }else{
                pq.add(new Pair(num,map.get(num)));
            }
            
        }
        
        int ans []= new int[k];
        int i=0;
        while(pq.size()>0){
            ans[i] = pq.remove().num;
            i++;
        }
        
        return ans;
    }
    
}