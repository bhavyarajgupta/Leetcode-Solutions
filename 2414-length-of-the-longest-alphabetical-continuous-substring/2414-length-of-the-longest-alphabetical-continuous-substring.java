class Solution {
    
    public int longestContinuousSubstring(String s) {
        int j = 0, res = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(j) + i - j)
                j = i;
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}