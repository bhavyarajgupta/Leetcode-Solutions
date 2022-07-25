class Solution {
    public int rob(int[] nums) {
        int inc= nums[0];
        int exc =0;
        for(int i=1;i<nums.length;i++){
            
            int newinc = exc + nums[i];
            int newexc = Math.max(inc,exc);
            
            exc = newexc;
            inc = newinc;
        }
        
        return Math.max(inc,exc);
    }
}