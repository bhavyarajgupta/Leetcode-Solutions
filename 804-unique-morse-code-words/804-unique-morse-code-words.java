class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        HashSet<String> set = new HashSet<>();
        
        String [] Morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(int i=0;i<words.length;i++){
            String s = words[i];
            String concat = "";
            for(int j=0;j<s.length();j++){
                concat += Morse[s.charAt(j)-'a'];
            }
            
            set.add(concat);
        }
        
        return set.size();
    }
}