class Solution {
    public boolean checkIfPangram(String sentence) {
     
        boolean charstore[] = new boolean[26];
        
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            
            charstore[ch-'a'] = true;
        }
        
        
        for(boolean check:charstore){
            if(check == false)
                return false;
        }
        
        return true;
    }
}