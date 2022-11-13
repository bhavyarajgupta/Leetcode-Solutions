class Solution {
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        
        int j=words.length-1;
        
        StringBuilder sb = new StringBuilder("");
        while(j>=0){
            sb.append(words[j]);
            if(j>0)
                sb.append(" ");
            
            j--;
        }
        
        return sb.toString().trim();
    }
}