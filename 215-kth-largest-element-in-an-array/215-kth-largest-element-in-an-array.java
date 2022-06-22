class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        int max = 0;
        
        for(int i=0;i<nums.length;i++){
            minheap.add(nums[i]);
        }
        
        for(int i=0;i<=nums.length-k;i++){
            max = minheap.remove();
        }
        
        return max;
    }
}