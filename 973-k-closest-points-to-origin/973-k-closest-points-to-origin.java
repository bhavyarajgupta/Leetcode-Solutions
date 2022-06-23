class Solution {
    
    static class Pair implements Comparable<Pair>{
        int x, y;
        double distancefromorigin;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            distancefromorigin = Math.sqrt(x*x + y*y);
        }
        
        @Override
        public int compareTo(Pair pair) {
            if(distancefromorigin < pair.distancefromorigin)
                return -1;
            return 1;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int[] point : points) {
            list.add(new Pair(point[0], point[1]));
        }
        
        pq.addAll(list);
        
        int[][] ans = new int[k][2];
        
        int idx = 0;
        while(k --> 0) {
            Pair temp = pq.remove();
            ans[idx][0] = temp.x;
            ans[idx][1] = temp.y;
            idx++;
        }
        
        return ans;
    }
}