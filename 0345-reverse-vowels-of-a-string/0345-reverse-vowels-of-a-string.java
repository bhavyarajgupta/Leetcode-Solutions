class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        
        
        int i =0;
        int j = s.length()-1;
        StringBuilder ans = new StringBuilder(s);
        while(i<j){
            if(vowels.indexOf(s.charAt(i))!= -1){
                
                if(vowels.indexOf(s.charAt(j))!= -1){
                    char ch = ans.charAt(i);
                    ans.setCharAt(i,ans.charAt(j));
                    ans.setCharAt(j,ch);
                    i++;
                }
                 
                   j--;
            }else if(vowels.indexOf(s.charAt(j))!= -1){
                if(vowels.indexOf(s.charAt(i))!= -1){
                    char ch =ans.charAt(i);
                    ans.setCharAt(i,ans.charAt(j));
                    ans.setCharAt(j,ch);
                    j--;
                }
                
                 i++;  
            }else{
                i++;
                j--;
            }
        }
        
        return ans.toString();
    }
}