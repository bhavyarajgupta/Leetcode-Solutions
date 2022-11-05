class Solution {
    
    private boolean check(String s1,String s2){
        if(s1.length() != s2.length()+1) return false; // sort according to string length
        
        int i =0;
        int j =0;
        
        
        while(i<s1.length()){
            if(j<s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        
        if(i == s1.length() && j == s2.length()) return true;
        
        return false;
        
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        int dp[] = new int[words.length];
        Arrays.fill(dp,1);
        
        int maxi =1;
      
        for(int i =0 ;i<words.length;i++){
            for(int prev = 0; prev < i;prev++){
                if( check(words[i] , words[prev])  && 1+dp[prev] > dp[i]  ){
                    dp[i] = 1+dp[prev];
                }
            }
            
            if(dp[i]>maxi){
                maxi = dp[i];
            }
        }
        
        return maxi;
    }
}