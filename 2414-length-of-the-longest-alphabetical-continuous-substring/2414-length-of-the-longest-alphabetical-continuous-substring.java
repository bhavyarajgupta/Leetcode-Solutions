class Solution {
    
    public int longestContinuousSubstring(String s) {
        int max=1;
        int i=0,j=1;
        s=s+" ";
       while(j<s.length()){
           char ch=s.charAt(j);
           if(ch-s.charAt(j-1)==1){
               j++;
           }
           else{
               max=Math.max(max,j-i);
               i=j;
               j++;
           }
       }
        return max;
    }
}