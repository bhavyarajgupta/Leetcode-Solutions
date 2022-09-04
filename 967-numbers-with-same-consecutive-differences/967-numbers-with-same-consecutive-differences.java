class Solution {
    
    ArrayList<Integer> ans = new ArrayList<>();
    
    private void dfs(int n, int k, int num, int digits) {
        
        if(digits == n) {
            ans.add(num);
            return;
        }
        
        int count = 0;
        while(count <= 9) {
            if(Math.abs(num%10 - count) == k) {
                dfs(n, k, num*10 + count, digits+1);
            }
            count++;
        }
        
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i <= 9; i++)
            dfs(n, k, i, 1);
        
        int[] nums = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            nums[i] = ans.get(i);
        
        return nums;
    }
}