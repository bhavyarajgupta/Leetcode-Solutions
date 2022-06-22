class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
       int max = 0;
        
        for(int i=0;i<nums.length;i++){
            maxheap.add(nums[i]);
        }
        
        for(int i=0;i<k;i++){
            max = maxheap.remove();
        }
        
        return max;
    }
}