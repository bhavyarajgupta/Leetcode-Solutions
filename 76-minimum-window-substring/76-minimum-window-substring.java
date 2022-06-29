class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";
        
        if(s.indexOf(t) != -1) return t;
        
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++)
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        
        int windowsize = Integer.MAX_VALUE, count = 0;
        int left = 0, start = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            if(tmap.containsKey(s.charAt(i))) {         
                
                smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
                if(smap.getOrDefault(s.charAt(i), 0) <= tmap.get(s.charAt(i))) {
                    count++;                
                }
            }
            
            while (count == t.length()) {
                
                int temp = i + 1 - left;
                if(temp < windowsize) {
                    windowsize = temp;
                    start = left;
                }
                
                if(tmap.containsKey(s.charAt(left))) {
                    smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);
                    if(smap.get(s.charAt(left)) < tmap.get(s.charAt(left))) {
                        count--;
                    }
                }
                
                left++;
                
            }
            
        }
        
        return windowsize == Integer.MAX_VALUE? "" : s.substring(start, start + windowsize);
    }
}