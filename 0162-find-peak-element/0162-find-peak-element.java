class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int high = nums.length-1;
        
        while(lo < high){
            int mid = lo + (high-lo)/2;
            
            if(mid == 0){
                return nums[0] > nums[1] ? 0:1;
            }
            else if(mid == nums.length-1)
            {
                return nums[mid] > nums[mid-1] ? mid : mid-1; 
            }
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(nums[mid] < nums[mid+1]){
                lo = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return lo;
    }
}