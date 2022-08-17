class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend < 0 && divisor < 0)
        {
            if (dividend ==  Integer.MIN_VALUE && ((divisor == 1) || (divisor == -1)))
            {
                return Integer.MAX_VALUE;
            }
        }
        int ans = (int) (dividend / divisor);
        return ans;
    
    }
}