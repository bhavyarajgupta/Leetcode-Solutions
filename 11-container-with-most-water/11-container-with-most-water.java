class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length-1;
        int res =Integer.MIN_VALUE;
        
        while(i<j){
            
            int ht = Math.min(height[i],height[j]);
            int area = ht * (j-i);
            res = Math.max(area,res);
            
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        
        return res;
    }
}