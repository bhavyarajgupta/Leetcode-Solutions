class Solution {
    public int trap(int[] height) {
        
        int i = 0;
        int j = height.length-1;
        int imax = height[i];
        int jmax = height[j];
        
        int ans = 0;
        
        while(i<j){
            if(imax<jmax){
                i++;
                imax = Math.max(imax,height[i]);
                
            }else{
                j--;
                jmax = Math.max(jmax,height[j]);
            }
            
            ans += Math.max(imax-height[i],jmax-height[j]);
            
        }
        
        return ans;        
    }
}