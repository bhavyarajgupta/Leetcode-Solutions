class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        int max = Integer.MIN_VALUE;
        
        for(int i=nums.length-1;i>1;i--){
            
            if(nums[i-1]+nums[i-2] > nums[i]){
                max = Math.max(nums[i-1]+nums[i-2]+nums[i],max);
            }
        }
        
        return max < 0 ? 0 : max;
    }
}