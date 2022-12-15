class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int high  = nums.length-1;
        
        if(nums.length <= 1) return nums[0];
        if( nums[lo] != nums[lo+1])return nums[lo];
        else if(nums[high] != nums[high-1]){
            return nums[high];
        }
        
        while(lo<high){
            int mid = lo + (high-lo)/2;
            
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];
            
            if((mid % 2 == 1 && nums[mid] == nums[mid-1] )|| (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                lo = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        
        return nums[lo];
    }
}