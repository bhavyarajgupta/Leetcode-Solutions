class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        int max = neededTime[0];
        
        for(int i = 1; i < colors.length(); i++) {
            char ch1 = colors.charAt(i);
            char ch2 = colors.charAt(i - 1);
            
            if(ch1 == ch2) {
                sum += Math.min(neededTime[i], max);
                max = Math.max(neededTime[i], max);
            } else
                max = neededTime[i];
        }
        
        return sum;
    }
}