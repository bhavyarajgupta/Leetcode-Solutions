class Solution {
    
    private String reverse(String s){
        StringBuilder ans = new StringBuilder(s);
        return ans.reverse().toString();
        
    }
    
    public String reverseWords(String s) {
        String [] store = s.split(" ");
        StringBuilder ans = new StringBuilder("");
        
        for(int i=0;i<store.length;i++){
            String temp = reverse(store[i]);
            ans.append(temp);
            
            ans.append(" ");
        }
        
        // ans.deleteCharAt(ans.length()-1);
        
        return ans.toString().trim();
    }
}