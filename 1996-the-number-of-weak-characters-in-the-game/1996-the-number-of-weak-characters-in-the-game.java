class Solution {
    
    
    public int numberOfWeakCharacters(int[][] pr) {
        
        Arrays.sort(pr,(a,b) -> b[0] == a[0] ? b[1]-a[1]:a[0]-b[0]);
        
        int ans = 0;
        int maxdef = Integer.MIN_VALUE;
        
        for(int i = pr.length-1;i>=0;i--){
            if(pr[i][1] < maxdef){
                ans++;
            }else{
                maxdef = pr[i][1];
            }
        }
        
        return ans;
        
    }
}