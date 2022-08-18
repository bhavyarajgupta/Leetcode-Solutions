class Solution {
    
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val : arr)
            map.put(val, map.getOrDefault(val, 0) + 1);
        
        for(Integer e : map.values()) {
            pq.add(e);
        }

        int count = 0;
        int size = 0;
        while(pq.size() > 0) {
            count++;
            size += pq.remove();
            if(size >= arr.length/2) return count;
        }
        
        return count;
    }
}