class Solution {
    public int firstUniqChar(String s) {
        
//         HashMap<Character,Integer> map = new LinkedHashMap<>();
        
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
        
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
            
//             if(map.get(ch) == 1){
//                 return i;
//             }
//         }
        
//         return -1;
        
        int[] count = new int[26];
        
        
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
            
        }
        
        return -1;
    }
}