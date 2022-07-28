class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        HashMap<Character,Integer> store1 = new HashMap<>();
        HashMap<Character,Integer> store2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            store1.put(ch1,store1.getOrDefault(ch1,0)+1);
            store2.put(ch2,store2.getOrDefault(ch2,0)+1);
        }
        
        boolean ans = false;
        
        for(Character ch:store1.keySet()){  
            
            int no1 = store1.getOrDefault(ch,0);
            int no2 = store2.getOrDefault(ch,0);
            if(no1 == no2){
                ans = true;
            }else{
                return false;
            }
        }
        
        return ans;
    }
}