class Solution {
    
    private String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }
    
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            
            String s = strs[i];
            String srt = sortString(s);
            
            if(map.containsKey(srt)){
                map.get(srt).add(s);
            }else{
                map.put(srt,new ArrayList<>());
                map.get(srt).add(s);
            }
            
            
        }
        
        List<List<String>> ans = new ArrayList<>();

        for(String l:map.keySet()){
              ans.add(map.get(l));
        }

        return ans;
        
    }
}