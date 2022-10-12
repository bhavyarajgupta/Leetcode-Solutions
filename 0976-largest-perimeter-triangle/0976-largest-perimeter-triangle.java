class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        // int max = Integer.MIN_VALUE;
        
        for(int i=nums.length-1;i>1;i--){
            
            if(nums[i-1]+nums[i-2] > nums[i]){
                return nums[i-1]+nums[i-2]+nums[i];
            }
        }
        
        return 0;
    }
}