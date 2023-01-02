class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isFirst = false;
        int count = 0;
        
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) == Character.toUpperCase(word.charAt(i))){
                if(i == 0) isFirst = true;
                count++;
            }
        }
        
        if(count == word.length()) return true;
        if(count == 0) return true;
        if(isFirst && count == 1) return true;
        
        
        return false;
        
    }
}