class Solution {
    
    private String sortString(String s){
        char tempArray[] = s.toCharArray();
 
        Arrays.sort(tempArray);
 
        return new String(tempArray);
        
    }
    
    public String orderlyQueue(String s, int k) {
        if(k>1){
            return sortString(s);
        }
        
        String ans  = s;
            for(int i=0;i< s.length(); i++){
                s = s.substring(1) + s.substring(0,1);
                if(ans.compareTo(s) >0){
                    ans = s;
                }
            }
        return ans;
    }
}