class Solution {
    public int wiggleMaxLength(int[] nums) {
        int i = 1, count = 0, last = 0;
        
        while(i < nums.length) {
            
            if((last == 0 || last < 0) && nums[i] - nums[i-1] > 0) {
                
                last = nums[i] - nums[i-1];
                count++;
                i++;
            } else if((last == 0 || last > 0) && nums[i] - nums[i-1] < 0){
                last = nums[i] - nums[i-1];
                count++;
                i++;
            } else {
                i++;
            }
            
   
        }
        
        return count+1;
    }
}