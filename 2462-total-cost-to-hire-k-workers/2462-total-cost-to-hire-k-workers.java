class Solution {
    
    class Pair implements Comparable<Pair>{
        int num;
        int index;
        
        Pair(int n,int i){
            num = n;
            index = i;
        }
        
        public int compareTo(Pair other){
            return num-other.num;
        }
        
        // public String toString(){
        //     return "num: "+num+" i: "+index;
        // }
    }
    
    public long totalCost(int[] costs, int k, int candidates) {
        
        PriorityQueue<Pair> pq1= new PriorityQueue<>();
        PriorityQueue<Pair> pq2= new PriorityQueue<>();
        
        int i = 0;
        int j = costs.length-1;
        
        long sum = 0;
        while( k-- > 0){
                
            while(i<=j && pq1.size()<candidates){
                pq1.add(new Pair(costs[i],i));   
                i++;
            }

            while(i<=j && pq2.size()<candidates){
                pq2.add(new Pair(costs[j],j)) ;
                j--;
            }

            if(pq1.size() == 0){
                sum+= pq2.remove().num;
            }else if(pq2.size() == 0){
                sum+= pq1.remove().num;
            }else if(pq1.peek().num == pq2.peek().num){
                if(pq1.peek().index < pq2.peek().index){
                    sum += pq1.remove().num;
                }else{
                    sum += pq2.remove().num;
                }
            }
            else if(pq1.peek().num < pq2.peek().num){
                sum += pq1.remove().num;
            }else{
                sum += pq2.remove().num;
            }            
            
        }
        
        return sum;
    }
}