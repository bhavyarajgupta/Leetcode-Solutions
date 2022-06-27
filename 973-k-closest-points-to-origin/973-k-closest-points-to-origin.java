class Solution {
    
     
    static class Pair{
       public int x,y;
    }
    
    static class Euclidian implements Comparator<Pair>{
        public int compare(Pair c1, Pair c2){
            double d1 = Math.sqrt(c1.x*c1.x + c1.y*c1.y);
            double d2 = Math.sqrt(c2.x*c2.x + c2.y*c2.y);
            
            if(d1<d2){
                return -1;
            }else if(d1>d2){
                return 1;
            }
            
            return 0;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Euclidian());
        
        
    for(int i=0;i<points.length;i++){
        Pair p = new Pair();
        p.x = points[i][0];
        p.y=  points[i][1];
        pq.add(p);
    }
        
        
        
        int[][] ans = new int[k][2];
        
        int idx = 0;
        while(idx<k) {
            Pair temp = pq.remove();
            ans[idx][0] = temp.x;
            ans[idx][1] = temp.y;
            idx++;
        }
        
        return ans;
    }
}