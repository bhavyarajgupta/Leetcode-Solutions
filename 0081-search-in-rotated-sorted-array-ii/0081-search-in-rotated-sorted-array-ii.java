class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int high = nums.length-1;
        
        while(lo<=high){
            if(lo < high && nums[lo] == nums[lo+1]){
                lo++;
            }else if(lo < high && nums[high] == nums[high-1]){
                high--;
            }else{
            int mid = lo+(high-lo)/2;
            
            if(nums[mid] == target) return true;
            
            if(nums[lo] <= nums[mid]){
                if(target >= nums[lo] && target <= nums[mid]){
                    high = mid-1;
                }else
                lo = mid+1;
                
            }else{
                if(target >= nums[mid] && target <= nums[high]){
                    lo = mid+1;
                }else
                high = mid-1;
                
            }
            }
        }
        return false;
    }
}