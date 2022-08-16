class Solution {
    public char repeatedCharacter(String s) {
    int[] arr=new int[26];
    int i=0;
    for(i=0;i<s.length();i++){
        
        if(arr[s.charAt(i)-'a']==1) break;
        arr[s.charAt(i)-'a']++;
    }
    return s.charAt(i);
    }
}