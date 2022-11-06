class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        Set<Integer> curSet = new HashSet<>();
        
        int left = 0;
        int right = 0;
        long curSum = 0;
            
        while (right < nums.length) {
            if (curSet.size() == k) {
                maxSum = Math.max(maxSum, curSum);
            }
            
            //Shrinking: Make sure size of window is k.
            while (left <= right - k) {
                curSet.remove(nums[left]);
                curSum -= nums[left];
                left++;                
            }
            
            //Check nums[right] in the current set, increasing left until found the duplication
            if (curSet.contains(nums[right])) {
                boolean found = false;
                while (left < right && !found) {
                    curSet.remove(nums[left]);
                    curSum -= nums[left];
                    if (nums[left] == nums[right]) {
                        found = true;
                    }
                    left++;
                }
            }
            
            //Add right to curSum and curSet
            curSum += nums[right];
            curSet.add(nums[right]);
            right++;
        }

        //Last window
        if (curSet.size() == k) {
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;        
    }
}