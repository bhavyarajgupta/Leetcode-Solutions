class Solution {
    
    private boolean isPossible(int[] weights, int days,int k){
        
        int count=0;
        int temp = 0;
        for(int i=0;i<weights.length;i++){
            temp += weights[i];
            if(temp == k){
                count++;
                temp = 0;
            }else if(temp > k){
                count++;
                temp = weights[i];
            }
        }
        
        if(temp>0)count++;
        
        return count<= days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int lo = Integer.MIN_VALUE;
        int high = 0;
        
        for(int i:weights){
            lo = Math.max(lo,i);
            high += i;
        }
        
        int ans =-1;
        
        while(lo<=high){
            int mid = lo + (high-lo)/2;
            
            if(isPossible(weights,days,mid)){
                ans  = mid;
                high = mid-1;
            }else{
                lo = mid+1;
            }
            
        }
        
        return ans;
    }
}