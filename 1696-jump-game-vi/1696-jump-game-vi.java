
class Pair{
        int sum;
        int idx;
        
        Pair(int a,int b){
            this.sum =a;
            this.idx =b;
        }
    }

class Compare implements Comparator<Pair>{
    public int compare(Pair x,Pair y){
        
        if(x.sum > y.sum){
            return -1;
        }
        
        return 1;
    }
}


class Solution {
    
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Compare());
        pq.add(new Pair(nums[0],0));
        int n = nums.length;
        
        for(int i=1;i<n;i++){
            Pair x = pq.peek();
            int sum = x.sum;
            int idx = x.idx;
            
            while(idx < i-k){
                pq.remove();
                sum = pq.peek().sum;
                idx = pq.peek().idx;
            }
        
            if(i!=n-1)            //is not last element
                pq.add(new Pair(sum+nums[i],i));
            else
                return sum+nums[i];
        }
        
       
        return nums[0];
    }
}
