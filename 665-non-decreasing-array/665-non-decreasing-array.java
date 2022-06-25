class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int count = 0;
    
        
        for(int i=0;i<=nums.length-2;i++){
            
            if(nums[i] > nums[i + 1]){
                count++;
                if(i>0 && nums[i-1]>nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i]= nums[i+1];
                }
                
            }
            
        }
        
        if(count > 1){
            return false;
        }
        
        return true;
    }
}