class Solution {
    
    private boolean isPossible(int[] piles,int h,int k){
        long count = 0;
        
        for(int i=0;i<piles.length;i++){
            count += piles[i]/k;
            if(piles[i]%k != 0){
                count++;
            }
        }
        
        return count<= h; 
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int high = Integer.MIN_VALUE;
        
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        
        int ans = high;
        
        while(lo <= high){
            int mid = lo +(high-lo)/2;
            
            if(isPossible(piles,h,mid)){
               ans = mid;
               high = mid-1;
            }else{
               lo = mid+1; 
            }
            
        }
        
        return ans;
    }
}