class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0;
        
        for(int i:piles){
            total += i;
            pq.add(i);
        }
        
        while(k-->0){
            int temp = pq.poll();
            total = total - (int) Math.floor(temp/2);
            temp -= (int) Math.floor(temp/2);
            pq.add(temp);
            // System.out.println(pq +" " + total);
        }
        
        return total;
        
    }
}