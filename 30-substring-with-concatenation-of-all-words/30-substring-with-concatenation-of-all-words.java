class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int wordlen = len * words.length;
        
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        
        for(String st:words){
            map.put(st,map.getOrDefault(st,0)+1);
        }
        
        for(int i=0;i<s.length()-wordlen+1;i++){
            String check = s.substring(i,i+wordlen);
           
            
            HashMap<String,Integer> temp = new HashMap<>();
      
            for(int j=0;j<check.length()-len+1;j=j+len){
                if(map.containsKey(check.substring(j,j+len))){  
                                    
                    temp.put(check.substring(j,j+len),temp.getOrDefault(check.substring(j,j+len),0)+1);  
        
                                                             
                }
              
            }
            
            if(temp.equals(map)){
                res.add(i);
            }
            
            temp.clear();
        }
        
        return res;
        
    }
}