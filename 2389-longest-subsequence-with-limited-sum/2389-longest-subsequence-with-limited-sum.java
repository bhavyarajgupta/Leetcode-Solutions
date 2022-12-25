class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int ans[] = new int[queries.length];
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<queries.length; i++) {
            
            int maxSum = queries[i], sum = 0, cnt = 0, j = 0;
            
            while(j < n && sum + nums[j] <= maxSum) {
                sum += nums[j++];
                cnt++;
            }
            
            ans[i] = cnt;
        }
        
        return ans;
    }
}