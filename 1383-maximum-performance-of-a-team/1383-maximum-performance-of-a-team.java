class Solution {
    
    class Pair implements Comparable<Pair>{
        int speed;
        int eff;
        
        Pair(int s,int e){
            speed = s;
            eff = e;
        }
        
        public int compareTo(Pair other){
            return  speed - other.speed;
        }    
    }
    
    
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        List<Pair> worker = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            worker.add(new Pair(speed[i],efficiency[i]));
        }
        
        worker.sort((a,b) -> b.eff - a.eff);
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        
        long tspeed = 0;
        long maxPerf =0;
        
        for(Pair newhire:worker){
            
            if(pq.size()==k){
                Pair slowGuy = pq.poll();

                tspeed -= slowGuy.speed;
            }
            
            pq.add(newhire);
            
            
            tspeed += newhire.speed;
            
            maxPerf = Math.max(maxPerf , tspeed * (long)newhire.eff);
            
        }
        
        return (int)(maxPerf % 1000000007);
    }
}