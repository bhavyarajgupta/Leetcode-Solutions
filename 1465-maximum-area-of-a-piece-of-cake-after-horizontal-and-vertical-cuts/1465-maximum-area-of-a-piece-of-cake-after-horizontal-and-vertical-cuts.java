class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int len = horizontalCuts.length >verticalCuts.length?horizontalCuts.length:verticalCuts.length;
        
        int x = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int y = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 1; i < len; i++) {
            
            if(i<horizontalCuts.length)
                x= Math.max(x, horizontalCuts[i] - horizontalCuts[i - 1]);
            
            if(i<verticalCuts.length)
                y= Math.max(y, verticalCuts[i] - verticalCuts[i - 1]);
            
        }
        
        
        return (int) ((long) x * (long)y % 1000000007L);
    }
}