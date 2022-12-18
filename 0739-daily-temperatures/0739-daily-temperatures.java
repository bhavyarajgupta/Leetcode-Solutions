class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[] = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        
        for(int i = 0; i < n; i++) {
            while(stk.size() > 0 && temperatures[stk.peek()] < temperatures[i]) {
                ans[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            
            stk.push(i);
        }
        
        return ans;
        
        
    }
}