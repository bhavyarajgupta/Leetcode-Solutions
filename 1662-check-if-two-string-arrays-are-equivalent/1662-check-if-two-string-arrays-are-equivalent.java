class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String var = String.join("",word1);
        String var2 = String.join("",word2);
        return var.equals(var2);
        
    }
}