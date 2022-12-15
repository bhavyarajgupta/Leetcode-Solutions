class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int high = nums.length-1;
        
        while(lo<high){
            int mid = lo +(high-lo)/2;
            
            if(nums[lo] < nums[high]) return nums[lo];
            
            if(nums[lo] > nums[mid]){
                high = mid;
            }else{
                lo = mid+1;
            }
            
        }
        
        return nums[lo];
    }
}