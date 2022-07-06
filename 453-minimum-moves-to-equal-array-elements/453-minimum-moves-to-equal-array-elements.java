class Solution {
    public int minMoves(int[] nums) {
         int sum = 0, min = Integer.MAX_VALUE;
        
        for(int num : nums) {
            sum += num;
            min = Math.min(num, min);
        }
        
        return sum - nums.length*min;
    }
}